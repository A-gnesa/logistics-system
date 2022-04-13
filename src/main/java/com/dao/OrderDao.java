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
            ",destination = '${order.destination}',price = ${order.price},transport_mode = ${order.transportMode.code},state = ${order.state.code}")
    int createOrder(@Param("order") Order order);

    /**
     * 更新订单状态
     * @param order order
     * @return 影响条数
     */
    @ReturnCheck
    @UpdateProvider(type = OrderProvider.class,method = "update")
    int updateOrder(Order order);
}
