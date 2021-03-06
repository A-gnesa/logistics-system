package com.dao.provide;

import com.enity.StoreRoom;
import org.apache.logging.log4j.util.Strings;

import java.util.Objects;

/**
 * @Author 赵冠乔
 * @Date 2022/4/10
 */
public class StoreRoomProvider {
    /**
     * 条件查询
     * select name, inventory, max_inventory, create_time, update_time from storeroom
     *
     * @param storeRoom storeRoom
     * @return sql
     */
    public String selectByCondition(StoreRoom storeRoom) {
        StringBuilder sql = new StringBuilder("select no,name, inventory, max_inventory, create_time,manager_no, update_time from storeroom WHERE 1 = 1");
        if (Objects.nonNull(storeRoom.getInventory())) {
            sql.append(" AND inventory = ").append(storeRoom.getInventory());
        }
        if (Objects.nonNull(storeRoom.getMaxInventory())) {
            sql.append(" AND max_inventory = ").append(storeRoom.getMaxInventory());
        }
        if (Strings.isNotBlank(storeRoom.getNo())) {
            sql.append(" AND INSTR(`no`, ").append("'").append(storeRoom.getNo()).append("') > 0");
        }
        if (Strings.isNotBlank(storeRoom.getName())) {
            sql.append(" AND INSTR(`name`, ").append("'").append(storeRoom.getName()).append("') > 0");
        }
        if (Strings.isNotBlank(storeRoom.getManagerNo())) {
            sql.append(" AND manager_no = '").append(storeRoom.getManagerNo()).append("' ");
        }
        if (Strings.isNotBlank(storeRoom.getCity())) {
            sql.append(" AND city = '").append(storeRoom.getCity()).append("' ");
        }
        return sql.toString();
    }

    /**
     * 更新
     *
     * @param storeRoom storeRoom
     * @return sql
     */
    public String update(StoreRoom storeRoom) {
        StringBuilder sql = new StringBuilder("update storeroom set update_time = now() ");
        if (Objects.nonNull(storeRoom.getMaxInventory())) {
            sql.append(",max_inventory = ").append(storeRoom.getMaxInventory());
        }
        if (Objects.nonNull(storeRoom.getInventory())) {
            sql.append(",inventory = ").append(storeRoom.getInventory());
        }
        if (Strings.isNotBlank(storeRoom.getName())) {
            sql.append(" , name = ' ").append(storeRoom.getName()).append("'");
        }
        if (Strings.isNotBlank(storeRoom.getCity())) {
            sql.append(" city = '").append(storeRoom.getCity()).append("' ");
        }
        sql.append(" where no = '").append(storeRoom.getNo()).append("'");
        return sql.toString();
    }
}
