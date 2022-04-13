package com.service;

import com.enity.MessageBean;
import com.enity.User;

/**
 * @Author 赵冠乔
 * @Date 2022/4/11
 */
public interface UserService {
    /**
     * 登录
     *
     * @param user user
     * @return MessageBean
     */
    MessageBean login(User user);

    /**
     * 添加用户
     *
     * @param user user
     * @return MessageBean
     */
    MessageBean addUser(User user);

    /**
     * 更新用户信息
     *
     * @param user user
     * @return MessageBean
     */
    MessageBean updateUser(User user);
}
