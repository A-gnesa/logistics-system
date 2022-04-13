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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author 赵冠乔
 * @Date 2022/4/13
 */
@Api(value = "库存Controller", tags = {"库存访问接口"})
@RestController
@RequestMapping("/storeroom")
public class StoreRoomController {
//    @Resource
//    StoreRoomService storeRoomService;
//
//    @PostMapping("/query")
//    @ApiOperation(value = "查询订单", httpMethod = "POST", notes = "查询包括编号，始发地，目的地，运输方式，价格，订单状态，可传空 查所有")
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 201, message = "失败")
//            , @ApiResponse(code = 9999, message = "系统错误"), @ApiResponse(code = 9001, message = "参数有误"), @ApiResponse(code = 9002, message = "请求超时")})
//    public MessageBean query(StoreRoom storeRoom) {
//        return storeRoomService.query(storeRoom);
//    }
//
//    @PostMapping("/createOrder")
//    @ApiOperation(value = "创建订单", httpMethod = "POST", notes = "创建订单。传入始发地，目的地，运输方式，价格且均不能为空")
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 201, message = "失败")
//            , @ApiResponse(code = 9999, message = "系统错误"), @ApiResponse(code = 9001, message = "参数有误"), @ApiResponse(code = 9002, message = "请求超时")})
//    public MessageBean createOrder(@Validated(Group.Insert.class) Order order) {
//        MessageBean result = checkPrice(order);
//        if (result != null){
//            return result;
//        }
//        return orderService.createOrder(order);
//    }
//
//    @PostMapping("/updateOrder")
//    @ApiOperation(value = "修改订单状态", httpMethod = "POST", notes = "修改订单。传入编号。")
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 201, message = "失败")
//            , @ApiResponse(code = 9999, message = "系统错误"), @ApiResponse(code = 9001, message = "参数有误"), @ApiResponse(code = 9002, message = "请求超时")})
//    public MessageBean updateOrder(@Validated(Group.Update.class) Order order) {
//        MessageBean result = checkPrice(order);
//        if (result != null){
//            return result;
//        }
//        return orderService.updateOrder(order);
//    }

}
