package com.dao.provide;

import com.enity.User;
import org.apache.logging.log4j.util.Strings;

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
        if (Strings.isNotBlank(user.getPassword())) {
            sql.append(",password = '").append(user.getPassword()).append("'");
        }
        if (Strings.isNotBlank(user.getName())) {
            sql.append(",name = '").append(user.getName()).append("'");
        }
        sql.append(" WHERE no = '").append(user.getNo()).append("'");
        return sql.toString();
    }
}
