package com.service;

import com.annotation.ReturnCheck;
import com.enity.MessageBean;
import com.enity.Order;
import com.enity.StoreRoom;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @Author 赵冠乔
 * @Date 2022/4/11
 */
public interface OrderService {
    /**
     * 根据条件查询
     *
     * @param order order
     * @return MessageBean
     */
    MessageBean query(Order order);

    /**
     * 生成订单
     *
     * @param order order
     * @return MessageBean
     */
    MessageBean createOrder(Order order);

    /**
     * 更新订单状态
     *
     * @param order order
     * @return MessageBean
     */
    MessageBean updateOrder(Order order);


    /**
     * 更改订单状态至运输中
     *
     * @param order order
     * @return MessageBean
     */
    MessageBean switchOrderStateToShipments(Order order);


    /**
     * 更改订单状态至已收货
     *
     * @param order order
     * @return MessageBean
     */
    MessageBean switchOrderStateToReceived(Order order);

}
