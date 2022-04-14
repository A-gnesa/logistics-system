package com.service.impl;

import com.dao.UserDao;
import com.enity.MessageBean;
import com.enity.User;
import com.enums.ErrorCodeEnum;
import com.service.UserService;
import com.utils.Md5Util;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author 赵冠乔
 * @Date 2022/4/11
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;
    @Resource
    RedisTemplate<String, Object> redisTemplate;

    private static final Long EXPIRATION_TIME = 15L;

    @Override
    public MessageBean login(User user) {
        user.setPassword(Md5Util.string2MD5(user.getPassword()));
        if (userDao.checkPasswordByTel(user) == 0) {
            return MessageBean.fail("账号或密码错误");
        }
        User realUser = userDao.findUserByTel(user.getTel());
        redisTemplate.opsForValue().set(realUser.getNo(), realUser.getNo());
        redisTemplate.expire(realUser.getNo(), EXPIRATION_TIME, TimeUnit.HOURS);
        return MessageBean.success(realUser);
    }

    @Override
    public MessageBean addUser(User user) {
        if (userDao.checkUserByName(user) > 1) {
            return MessageBean.fail("用户名重复");
        }
        user.setNo(UUID.randomUUID().toString());
        user.setPassword(Md5Util.string2MD5(user.getPassword()));
        boolean checkUserName = userDao.checkUserByName(user) == 1;
        boolean checkTel = userDao.checkUserByTel(user) == 1;
        if (checkTel || checkUserName){
            return new MessageBean(ErrorCodeEnum.INVALID_PARAMS,"用户名或电话号重复");
        }
        userDao.insertUser(user);
        return  MessageBean.success(user);
    }

    @Override
    public MessageBean updateUser(User user) {
        boolean checkUserName = userDao.checkUserByName(user) == 1;
        boolean checkTel = userDao.checkUserByTel(user) == 1;
        if (checkTel || checkUserName){
            return new MessageBean(ErrorCodeEnum.INVALID_PARAMS,"用户名或电话号重复");
        }
       userDao.updateUser(user);
       return MessageBean.success("修改成功");
    }
}
