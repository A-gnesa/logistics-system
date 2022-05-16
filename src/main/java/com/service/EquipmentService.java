package com.service;

import com.annotation.ReturnCheck;
import com.dao.provide.EquipmentProvider;
import com.enity.Equipment;
import com.enity.MessageBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Date 2022/5/15 5:47 PM
 * @Author 赵冠乔
 */
public interface EquipmentService {
    /**
     * 添加设备 传运输方式和名称
     * @param equipment 设备
     * @return 影响条数
     */
    MessageBean insertEquipment(Equipment equipment);

    /**
     * 查询设备
     * @param equipment equipment
     * @return 设备列表
     */
    MessageBean findEquipment(Equipment equipment);

    /**
     * 修改设备信息
     * @param equipment 设备编码
     * @return 影响条数
     */
    MessageBean updateEquipment(Equipment equipment);

}
