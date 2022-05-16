package com.controller;

import com.enity.Group;
import com.enity.MessageBean;
import com.enity.Order;
import com.enums.ErrorCodeEnum;
import com.service.OrderService;
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
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @Author 赵冠乔
 * @Date 2022/4/13
 */
@Api(value = "订单Controller", tags = {"订单访问接口"})
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;

    @GetMapping("/query")
    @ApiOperation(value = "查询订单", httpMethod = "POST", notes = "查询包括编号，始发地，目的地，运输方式，价格，订单状态，可传空 查所有")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 201, message = "失败")
            , @ApiResponse(code = 9999, message = "系统错误"), @ApiResponse(code = 9001, message = "参数有误"), @ApiResponse(code = 9002, message = "请求超时")})
    public MessageBean query(Order order) {
        return orderService.query(order);
    }

    @PostMapping("/createOrder")
    @ApiOperation(value = "创建订单", httpMethod = "POST", notes = "创建订单。传入始发地，目的地，运输方式，价格，" +
            "收件人，收件人电话，寄件人，寄件人电话且均不能为空")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 201, message = "失败")
            , @ApiResponse(code = 9999, message = "系统错误"), @ApiResponse(code = 9001, message = "参数有误"), @ApiResponse(code = 9002, message = "请求超时")})
    public MessageBean createOrder(@Validated(Group.Insert.class) Order order) {
        MessageBean result = checkPrice(order);
        if (result != null){
            return result;
        }
        return orderService.createOrder(order);
    }

    @PostMapping("/updateOrder")
    @ApiOperation(value = "修改订单状态", httpMethod = "POST", notes = "修改订单。传入编号。")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 201, message = "失败")
            , @ApiResponse(code = 9999, message = "系统错误"), @ApiResponse(code = 9001, message = "参数有误"), @ApiResponse(code = 9002, message = "请求超时")})
    public MessageBean updateOrder(@Validated(Group.Update.class) Order order) {
        MessageBean result = checkPrice(order);
        if (result != null){
            return result;
        }
        return orderService.updateOrder(order);
    }


    @PostMapping("/switchOrderStateToShipments")
    @ApiOperation(value = "更改订单状态至运输中", httpMethod = "POST", notes = "修改订单。传入编号,所选运输设备")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 201, message = "失败")
            , @ApiResponse(code = 9999, message = "系统错误"), @ApiResponse(code = 9001, message = "参数有误"), @ApiResponse(code = 9002, message = "请求超时")})
    public MessageBean switchOrderStateToShipments(@Validated(Group.Update.class) Order order) {
        return orderService.switchOrderStateToShipments(order);
    }


    @PostMapping("/switchOrderStateToReceived")
    @ApiOperation(value = "更改订单状态至已收货", httpMethod = "POST", notes = "更改订单状态至已收货。传入编号。")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 201, message = "失败")
            , @ApiResponse(code = 9999, message = "系统错误"), @ApiResponse(code = 9001, message = "参数有误"), @ApiResponse(code = 9002, message = "请求超时")})
    public MessageBean switchOrderStateToReceived(@Validated(Group.Update.class) Order order) {
        return orderService.switchOrderStateToReceived(order);
    }

    /**
     * 检查价格
     * @param order order
     * @return MessageBean
     */
    private MessageBean checkPrice(Order order) {
        if (Objects.isNull(order.getPrice())){
            return null;
        }
        BigDecimal max = BigDecimal.valueOf(99999999L);
        if (order.getPrice().compareTo(max) > 0) {
            return new MessageBean(ErrorCodeEnum.INVALID_PARAMS, "价格不能超过99999999");
        }
        if (order.getPrice().doubleValue() < 0) {
            return new MessageBean(ErrorCodeEnum.INVALID_PARAMS, "价格不能低于0");
        }
        return null;
    }
}
