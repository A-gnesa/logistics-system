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
        StringBuilder sql = new StringBuilder().append("select id, no, starting_point, destination, price, sender, \n" +
                "       sender_tel, addressee, addressee_tel, transport_no, \n" +
                "        state, create_time, update_time from `order` WHERE 1 = 1 ");
        if (Objects.nonNull(order.getPrice())) {
            sql.append("AND price = ").append(order.getPrice());
        }
        if (Strings.isNotBlank(order.getStartingPoint())) {
            sql.append(" AND INSTR(`starting_point`, ").append("'").append(order.getStartingPoint()).append("') > 0");
        }
        if (Strings.isNotBlank(order.getDestination())) {
            sql.append(" AND INSTR(`destination`, ").append("'").append(order.getDestination()).append("') > 0");
        }
        if (Strings.isNotBlank(order.getSender())) {
            sql.append(" AND INSTR(`sender`, ").append("'").append(order.getSender()).append("') > 0");
        }
        if (Strings.isNotBlank(order.getSenderTel())) {
            sql.append(" AND INSTR(`sender_tel`, ").append("'").append(order.getSenderTel()).append("') > 0");
        }
        if (Strings.isNotBlank(order.getAddressee())) {
            sql.append(" AND INSTR(`addressee`, ").append("'").append(order.getAddressee()).append("') > 0");
        }
        if (Strings.isNotBlank(order.getAddresseeTel())) {
            sql.append(" AND INSTR(`addressee_tel`, ").append("'").append(order.getAddresseeTel()).append("') > 0");
        }
        if (Strings.isNotBlank(order.getTransportNo())) {
            sql.append(" AND INSTR(`transport_no`, ").append("'").append(order.getTransportNo()).append("') > 0");
        }
        if (Strings.isNotBlank(order.getNo())) {
            sql.append(" AND INSTR(`no`, ").append("'").append(order.getNo()).append("') > 0");
        }
        if (Objects.nonNull(order.getState())) {
            sql.append(" AND state = ").append(order.getState().getCode());
        }
        if (Strings.isNotBlank(order.getNo())) {
            sql.append(" AND INSTR(`no`, ").append("'").append(order.getNo()).append("') > 0");
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
        if (Objects.nonNull(order.getState())) {
            sql.append(", state = ").append(order.getState().getCode());
        }
        if (Strings.isNotBlank(order.getSender())){
            sql.append(", sender = '").append(order.getSender()).append("'");
        }
        if (Strings.isNotBlank(order.getSenderTel())){
            sql.append(", sender_tel = '").append(order.getSenderTel()).append("'");
        }
        if (Strings.isNotBlank(order.getAddressee())){
            sql.append(", addressee = '").append(order.getSender()).append("'");
        }
        if (Strings.isNotBlank(order.getAddresseeTel())){
            sql.append(", addressee_tel = '").append(order.getSenderTel()).append("'");
        }
        if (Strings.isNotBlank(order.getTransportNo())){
            sql.append(", transport_no = '").append(order.getSenderTel()).append("'");
        }
        sql.append(" where no = '").append(order.getNo()).append("'");

        return sql.toString();

    }
}
