package com.service.impl;

import com.dao.OrderDao;
import com.enity.MessageBean;
import com.enity.Order;
import com.enums.OrderStateEnum;
import com.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author 赵冠乔
 * @Date 2022/4/11
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderDao orderDao;

    @Override
    public MessageBean query(Order order) {
        return MessageBean.success(orderDao.query(order));
    }

    @Override
    public MessageBean createOrder(Order order) {
        order.setNo(UUID.randomUUID().toString());
        order.setState(OrderStateEnum.CREATE);
        orderDao.createOrder(order);
        return MessageBean.success();
    }

    @Override
    public MessageBean updateOrder(Order order) {
        orderDao.updateOrder(order);
        return MessageBean.success();
    }
}
