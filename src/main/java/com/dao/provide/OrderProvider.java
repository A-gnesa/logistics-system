package com.dao.provide;

import com.enity.Order;
import org.apache.logging.log4j.util.Strings;

import java.util.Objects;

/**
 * @Author 赵冠乔
 * @Date 2022/4/11
 */
public class OrderProvider {
    /**
     * 查询订单
     * select id, no, starting_point, destination, price, create_time, update_time, transport_mode from `order`
     *
     * @param order order
     * @return sql
     */
    public String query(Order order) {
        StringBuilder sql = new StringBuilder().append("select no, starting_point, destination, price, create_time, update_time, state ,transport_mode from `order` WHERE 1 = 1 ");
        if (Objects.nonNull(order.getPrice())) {
            sql.append("price = ").append(order.getPrice());
        }
        if (Strings.isNotBlank(order.getStartingPoint())) {
            sql.append(" AND INSTR(`starting_point`, ").append("'").append(order.getStartingPoint()).append("') > 0");
        }
        if (Strings.isNotBlank(order.getDestination())) {
            sql.append(" AND INSTR(`destination`, ").append("'").append(order.getStartingPoint()).append("') > 0");
        }
        if (Strings.isNotBlank(order.getNo())) {
            sql.append(" AND INSTR(`no`, ").append("'").append(order.getNo()).append("') > 0");
        }
        if (Objects.nonNull(order.getTransportMode())) {
            sql.append(" AND transport_mode = ").append(order.getTransportMode().getCode());
        }
        if (Objects.nonNull(order.getState())) {
            sql.append(" AND state = ").append(order.getState().getCode());
        }
        return sql.toString();
    }

    public String update(Order order) {
        StringBuilder sql = new StringBuilder().append("update `order` set update_time = now() ");
        if (Objects.nonNull(order.getPrice())) {
            sql.append(", price = ").append(order.getPrice());
        }
        if (Strings.isNotBlank(order.getStartingPoint())) {
            sql.append(" ,`starting_point` = '").append(order.getStartingPoint()).append("'");
        }
        if (Strings.isNotBlank(order.getDestination())) {
            sql.append(" ,`destination` = '").append(order.getDestination()).append("'");
        }

        if (Objects.nonNull(order.getTransportMode())) {
            sql.append(" ,transport_mode = ").append(order.getTransportMode().getCode());
        }
        if (Objects.nonNull(order.getState())) {
            sql.append(", state = ").append(order.getState().getCode());
        }
        sql.append(" where no = '").append(order.getNo()).append("'");

        return sql.toString();

    }
}
