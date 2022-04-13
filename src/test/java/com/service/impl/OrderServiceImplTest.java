package com.service.impl;

import com.dao.OrderDao;
import com.enity.Order;
import com.enums.OrderStateEnum;
import com.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author 赵冠乔
 * @Date 2022/4/13
 */
@SpringBootTest
class OrderServiceImplTest {
    @Resource
    OrderDao orderDao;

    @Resource
    OrderService orderService;
    @Test
    void query() {
        System.out.println(orderService.query(new Order().setState(OrderStateEnum.CREATE)));
    }

    @Test
    void createOrder() {
    }

    @Test
    void updateOrder() {
    }
}