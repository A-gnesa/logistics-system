package com.dao;

import com.annotation.ReturnCheck;
import com.dao.provide.OrderProvider;
import com.enity.Order;
import com.enity.User;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

/**
 * @Author 赵冠乔
 * @Date 2022/4/11
 */

@Mapper
public interface OrderDao {
    /**
     * 查询订单
     * select id, no, starting_point, destination, price, create_time, update_time, state, transport_mode from `order`
     * @param order order
     * @return 订单
     */
    @SelectProvider(type = OrderProvider.class,method = "query")
    ArrayList<Order> query(Order order);

    /**
     * 生成订单
     * @param order order
     * @return 影响条数
     */
    @ReturnCheck
    @Insert("insert into `order` set no = '${order.no}',starting_point = '${order.startingPoint}'" +
            ",destination = '${order.destination}',price = ${order.price}," +
            "state = ${order.state.code},sender = '${order.sender}',sender_tel = '${order.senderTel}'," +
            "addressee = '${order.addressee}',addressee_tel = '${order.addresseeTel}'," +
            "transport_no = '${order.transportNo}'")
    int createOrder(@Param("order") Order order);

    /**
     * 更新订单状态
     * @param order order
     * @return 影响条数
     */
    @ReturnCheck
    @UpdateProvider(type = OrderProvider.class,method = "update")
    int updateOrder(Order order);

    /**
     * 更改订单状态至运输中
     * @param order order
     * @return 影响条数
     */
    @ReturnCheck
    @Update("update `order` set update_time = now(),state = 1 ,transport_no = '${order.transportNo}' WHERE no = '${order.no}'")
    int switchOrderStateToShipments(@Param("order") Order order);


    /**
     * 更改订单状态至已收货
     * @param order order
     * @return 影响条数
     */
    @ReturnCheck
    @Update("update `order` set update_time = now(),state = 2 WHERE no = '${order.no}'")
    int switchOrderStateToReceived(@Param("order")Order order);
}
