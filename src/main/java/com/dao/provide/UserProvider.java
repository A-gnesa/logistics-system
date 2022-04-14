package com.dao.provide;

import com.enity.User;

import java.util.Objects;

/**
 * @Author 赵冠乔
 * @Date 2022/4/10
 */
public class UserProvider {
    /**
     * 插入语句
     *
     * @param user user
     * @return sql
     */
    public String insertUser(User user) {
        return "INSERT INTO user\n" + "SET " + "no = '" + user.getNo() +
                "',name = '" + user.getName() +
                "',password = '" + user.getPassword() +
                "',tel = '" + user.getTel() + "'";
    }

    /**
     * 更新用户信息
     *
     * @param user user
     * @return sql
     */
    public String updateUser(User user) {
        StringBuilder sql = new StringBuilder("UPDATE user\n" + "SET ");
        sql.append("update_time = NOW()");
        if (Objects.nonNull(user.getTel())) {
            sql.append(",tel = '").append(user.getTel()).append("'");
        }
        if (Objects.nonNull(user.getPassword())) {
            sql.append(",password = ").append(user.getPassword());
        }
        sql.append("WHERE no = '").append(user.getNo()).append("'");
        return sql.toString();
    }
}
