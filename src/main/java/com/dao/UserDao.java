package com.dao;

import com.dao.provide.UserProvider;
import com.enity.User;
import org.apache.ibatis.annotations.*;

/**
 * @Author 赵冠乔
 * @Date 2022/4/10
 */
@Mapper
public interface UserDao {
    /**
     * 通过no查找用户
     *
     * @param no no
     * @return User
     */
    @Select("SELECT * FROM user WHERE no = ${no}")
    User findUserByNo(@Param("no") String no);

    /**
     * 通过name查找用户
     *
     * @param name name
     * @return User
     */
    @Select("SELECT * FROM user WHERE name = '${name}'")
    User findUserByName(@Param("name") String name);

    /**
     * 根据用户名检查密码
     *
     * @param user user
     * @return 返回用户条数
     */
    @Select("SELECT count(1) FROM user WHERE name = '${user.name}' AND password = '${user.password}'")
    int checkPasswordByUserName(@Param("user") User user);

    /**
     * 更新用户信息
     *
     * @param user user
     * @return 返回用户条数
     */
    @UpdateProvider(type = UserProvider.class, method = "updateUser")
    int updateUser(User user);

    /**
     * 查询用户名是否重复
     *
     * @param user user
     * @return 返回用户条数
     */
    @Select("SELECT count(1) FROM user WHERE name = '${user.name}'")
    int checkUserByName(@Param("user") User user);


    /**
     * 创建用户
     *
     * @param user user
     * @return 插入个数
     */
    @InsertProvider(type = UserProvider.class, method = "insertUser")
    int insertUser(User user);

}
