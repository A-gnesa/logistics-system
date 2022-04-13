package com.service.impl;

import com.dao.UserDao;
import com.enity.MessageBean;
import com.enity.User;
import com.service.UserService;
import com.utils.Md5Util;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author 赵冠乔
 * @Date 2022/4/11
 */
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;
    @Resource
    RedisTemplate<String, Object> redisTemplate;

    private static final Long EXPIRATION_TIME = 15L;

    @Override
    public MessageBean login(User user) {
        if (userDao.checkPasswordByUserName(user) == 0) {
            return MessageBean.fail("账号或密码错误");
        }
        User realUser = userDao.findUserByName(user.getName());
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
        return userDao.insertUser(user) == 0 ? MessageBean.fail("注册失败") : MessageBean.success(user);
    }

    @Override
    public MessageBean updateUser(User user) {
        return userDao.updateUser(user) == 0 ? MessageBean.fail("修改失败") : MessageBean.success("修改成功");
    }
}
