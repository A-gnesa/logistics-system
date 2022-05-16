package com.dao;

import com.enity.Equipment;
import com.enums.EquipmentStateEnum;
import com.enums.TransportModeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Date 2022/5/15 2:54 PM
 * @Author 赵冠乔
 */
@SpringBootTest
class EquipmentDaoTest {
    @Resource
    EquipmentDao equipmentDao;
    @Test
    void insertEquipment() {
        equipmentDao.insertEquipment(new Equipment().setNo(UUID.randomUUID().toString()).setName("汽车1号").setMode(TransportModeEnum.LAND));
    }

    @Test
    void findEquipment() {
        System.out.println(equipmentDao.findEquipment(new Equipment().setName("汽车").setMode(TransportModeEnum.LAND)));
    }

    @Test
    void updateEquipment() {
        Equipment equipment = new Equipment().setNo("53e0fd03-91f4-4e22-8319-726c6fef5b75").setName("修改汽车1号");
        equipmentDao.updateEquipment(equipment);
        System.out.println(equipmentDao.findEquipment(equipment));
    }

    @Test
    void updateState() {
        Equipment equipment = new Equipment().setNo("53e0fd03-91f4-4e22-8319-726c6fef5b75").setName("修改汽车1号").setState(EquipmentStateEnum.TRANSPORT);
        equipmentDao.updateState(equipment);
        System.out.println(equipmentDao.findEquipment(equipment));
    }
}