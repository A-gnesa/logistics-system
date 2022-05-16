package com.dao;

import com.annotation.ReturnCheck;
import com.dao.provide.CityProvider;
import com.dao.provide.EquipmentProvider;
import com.enity.City;
import com.enity.Equipment;
import com.enity.StoreRoom;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Date 2022/5/15 2:46 PM
 * @Author 赵冠乔
 */
@SuppressWarnings("UnusedReturnValue")
@Mapper
public interface EquipmentDao {
    /**
     * 添加设备 传运输方式和名称
     * @param equipment 设备
     * @return 影响条数
     */
    @InsertProvider(type = EquipmentProvider.class, method = "insertEquipment")
    @ReturnCheck
    int insertEquipment(Equipment equipment);

    /**
     * 查询设备
     * @param equipment equipment
     * @return 设备列表
     */
    @SelectProvider(type = EquipmentProvider.class, method = "findEquipment")
    List<Equipment> findEquipment(Equipment equipment);

    /**
     * 修改设备信息
     * @param equipment 设备编码
     * @return 影响条数
     */
    @UpdateProvider(type = EquipmentProvider.class, method = "updateEquipment")
    int updateEquipment(Equipment equipment);

    /**
     * 更改状态
     * @param equipment equipment
     * @return 影响条数
     */
    @Update("UPDATE equipment SET update_time = NOW(),state = ${equipment.state.code} WHERE no = '${equipment.no}'")
    @ReturnCheck
    int updateState(@Param("equipment") Equipment equipment);


    /**
     * 获取所属城市 汽车数量
     * @param city 城市名称
     * @return 所属城市 汽车数量
     */
    @Select("SELECT count(1) FROM equipment WHERE city = '${city}' AND mode = 0")
    int countCarByCity(@Param("city") String city);

    /**
     * 获取所属城市 汽车数量
     * @param city 城市名称
     * @return 所属城市 汽车数量
     */
    @Select("SELECT count(1) FROM equipment WHERE city = '${city}' AND mode = 1")
    int countAirByCity(@Param("city") String city);

}
