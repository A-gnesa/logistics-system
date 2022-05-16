package com.dao;

import com.enity.Order;
import com.enums.OrderStateEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Date 2022/5/15 7:25 PM
 * @Author 赵冠乔
 */
@SpringBootTest
class OrderDaoTest {
    @Resource
    OrderDao orderDao;

    Order order = new Order();
    @Test
    void query() {
        Order order1 = order.setStartingPoint("海").setDestination("台").setSender("人").setSenderTel("1").setAddressee("人").setSenderTel("1").setState(OrderStateEnum.CREATE);
        System.out.println(orderDao.query(order1));
    }

    @Test
    void updateOrder() {
        order.setStartingPoint("海").setDestination("台").setSender("人").setSenderTel("1").setAddressee("人").setSenderTel("1").setState(OrderStateEnum.CREATE).setNo("70823a01-ccc7-4726-b2ce-e8511516f797");
        System.out.println(orderDao.updateOrder(order));
    }

    @Test
    void createOrder() {
        order.setStartingPoint("海").setDestination("台").setSender("人").setSenderTel("1").setAddressee("人").setSenderTel("1").setState(OrderStateEnum.CREATE).setNo("70823a01-ccc7-4726-b2ce-e8511516f797");
        order.setNo(UUID.randomUUID().toString());
        order.setAddresseeTel("1");
        order.setTransportNo("1");
        order.setPrice(new BigDecimal(1L));
        orderDao.createOrder(order);

        System.out.println(orderDao.query(order));
    }

    @Test
    void switchOrderStateToCreate() {
        order.setNo("a47e2dec-688d-4621-b2f4-9b69a9b72d75");
        orderDao.switchOrderStateToShipments(order);
        System.out.println(orderDao.query(order));
    }

    @Test
    void switchOrderStateToReceived() {
        order.setNo("a47e2dec-688d-4621-b2f4-9b69a9b72d75");
        orderDao.switchOrderStateToReceived(order);
        System.out.println(orderDao.query(order));
    }
}