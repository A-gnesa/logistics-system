package com.controller;

import com.enity.Group;
import com.enity.MessageBean;
import com.enity.StoreRoom;
import com.enity.User;
import com.service.StoreRoomService;
import com.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Date 2022/4/14 10:21 AM
 * @Author 赵冠乔
 */

@Api(value = "用户Controller", tags = {"用户访问接口"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "登录", httpMethod = "POST", notes = "登录 传入电话和密码")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 201, message = "失败")
            , @ApiResponse(code = 9999, message = "系统错误"), @ApiResponse(code = 9001, message = "参数有误"), @ApiResponse(code = 9002, message = "请求超时")})
    public MessageBean login(@Validated(Group.Login.class) User user) {
        return userService.login(user);
    }

    @PostMapping("/createUser")
    @ApiOperation(value = "创建用户", httpMethod = "POST", notes = "注册。传入用户名,密码,电话均不能为空")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 201, message = "失败")
            , @ApiResponse(code = 9999, message = "系统错误"), @ApiResponse(code = 9001, message = "参数有误"), @ApiResponse(code = 9002, message = "请求超时")})
    public MessageBean create(@Validated(Group.Insert.class) User user) {
        return userService.addUser(user);
    }

    @PostMapping("/updateUser")
    @ApiOperation(value = "修改用户信息", httpMethod = "POST", notes = "修改用户。传入编号。")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 201, message = "失败")
            , @ApiResponse(code = 9999, message = "系统错误"), @ApiResponse(code = 9001, message = "参数有误"), @ApiResponse(code = 9002, message = "请求超时")})
    public MessageBean update(@Validated(Group.Update.class) User user) {
        return userService.updateUser(user);
    }


}
