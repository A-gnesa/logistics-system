package com.controller;

import com.enity.Group;
import com.enity.MessageBean;
import com.enity.Order;
import com.enity.StoreRoom;
import com.service.OrderService;
import com.service.StoreRoomService;
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
 * @Author 赵冠乔
 * @Date 2022/4/13
 */
@Api(value = "库房Controller", tags = {"库存访问接口"})
@RestController
@RequestMapping("/storeroom")
public class StoreRoomController {
    @Resource
    StoreRoomService storeRoomService;

    @GetMapping("/query")
    @ApiOperation(value = "查询库房", httpMethod = "GET", notes = "查询包括名称, 库存数量, 最大库存数量，可传空 查所有")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 201, message = "失败")
            , @ApiResponse(code = 9999, message = "系统错误"), @ApiResponse(code = 9001, message = "参数有误"), @ApiResponse(code = 9002, message = "请求超时")})
    public MessageBean query(StoreRoom storeRoom) {
        return storeRoomService.query(storeRoom);
    }

    @PostMapping("/createStoreRoom")
    @ApiOperation(value = "创建库房信息", httpMethod = "POST", notes = "创建库房。传入库存名称，现有库存数量，最大库存数量且均不能为空")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 201, message = "失败")
            , @ApiResponse(code = 9999, message = "系统错误"), @ApiResponse(code = 9001, message = "参数有误"), @ApiResponse(code = 9002, message = "请求超时")})
    public MessageBean addStoreRoom(@Validated(Group.Insert.class) StoreRoom storeRoom) {
        return storeRoomService.addStoreRoom(storeRoom);
    }

    @PostMapping("/updateStoreRoom")
    @ApiOperation(value = "修改库房信息", httpMethod = "POST", notes = "修改库存。传入编号。")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 201, message = "失败")
            , @ApiResponse(code = 9999, message = "系统错误"), @ApiResponse(code = 9001, message = "参数有误"), @ApiResponse(code = 9002, message = "请求超时")})
    public MessageBean updateOrder(@Validated(Group.Update.class) StoreRoom storeRoom) {
        return storeRoomService.updateStoreRoom(storeRoom);
    }
}
