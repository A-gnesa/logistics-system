package com.dao.provide;

import com.enity.City;
import com.enity.Equipment;
import org.apache.logging.log4j.util.Strings;

import java.util.Objects;

/**
 * @Date 2022/5/15 2:49 PM
 * @Author 赵冠乔
 */
public class EquipmentProvider {
    /**
     * 插入语句
     *
     * @param equipment equipment
     * @return sql
     */
    public String insertEquipment(Equipment equipment) {
        return "INSERT INTO equipment SET " + "no = '" + equipment.getNo() + "',mode = " + equipment.getMode().getCode() + ",name = '" + equipment.getName() + "',city = '" + equipment.getCity() + "'";
    }

    /**
     * 查询
     * @param equipment equipment
     * @return sql
     */
    public String findEquipment(Equipment equipment){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id , name , no , mode , create_time , update_time ,state , city FROM equipment WHERE 1 = 1");
        if (Strings.isNotBlank(equipment.getName())){
            sql.append(" AND INSTR(`name`, ").append("'").append(equipment.getName()).append("') > 0");
        }
        if (Objects.nonNull(equipment.getMode())){
            sql.append(" AND mode = ").append(equipment.getMode().getCode());
        }
        if (Strings.isNotBlank(equipment.getCity())){
            sql.append(" AND INSTR(`city`, ").append("'").append(equipment.getCity()).append("') > 0");
        }
        if (Strings.isNotBlank(equipment.getNo())){
            sql.append(" AND no = '").append(equipment.getNo()).append("'");
        }
        return sql.toString();
    }

    /**
     * 修改
     * @param equipment equipment
     * @return sql
     */
    public String updateEquipment(Equipment equipment) {
        StringBuilder sql = new StringBuilder();
        sql.append("update `equipment` set update_time = now()");
        if (Strings.isNotBlank(equipment.getName())) {
            sql.append(", name = '").append(equipment.getName()).append("'");
        }
        if (Objects.nonNull(equipment.getMode())) {
            sql.append(" ,mode = ").append(equipment.getMode().getCode());
        }
        if (Strings.isNotBlank(equipment.getCity())){
            sql.append(", city = '").append(equipment.getCity()).append("'");
        }
        if (Objects.nonNull(equipment.getState())){
            sql.append(", state = ").append(equipment.getState().getCode());
        }
        sql.append(" WHERE no = '").append(equipment.getNo()).append("'");
        return sql.toString();
    }
}
