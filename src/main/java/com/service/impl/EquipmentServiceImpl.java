package com.service.impl;

import com.dao.CityDao;
import com.dao.EquipmentDao;
import com.enity.Equipment;
import com.enity.MessageBean;
import com.enums.EquipmentStateEnum;
import com.service.EquipmentService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @Date 2022/5/15 5:48 PM
 * @Author 赵冠乔
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Resource
    private EquipmentDao equipmentDao;
    @Resource
    private CityDao cityDao;

    @Override
    public MessageBean insertEquipment(Equipment equipment) {
        equipment.setNo(UUID.randomUUID().toString());
        List<String> cityList = new ArrayList<>();
        cityDao.findAllCity().forEach(c -> cityList.add(c.getName()));
        if (!(cityList.contains(equipment.getCity()))) {
            return MessageBean.fail("所选城市信息错误");
        }
        List<Equipment> list = equipmentDao.findEquipment(new Equipment().setName(equipment.getName()));
        if (!(list.isEmpty()) && equipment.getName().equals(list.get(0).getName())){
            return MessageBean.fail("设备名称重复");
        }
        equipmentDao.insertEquipment(equipment);
        return MessageBean.success();
    }

    @Override
    public MessageBean findEquipment(Equipment equipment) {

        return MessageBean.success(equipmentDao.findEquipment(equipment));
    }

    @Override
    public MessageBean updateEquipment(Equipment equipment) {
        List<String> cityList = new ArrayList<>();
        cityDao.findAllCity().forEach(c -> cityList.add(c.getName()));
        if (Strings.isNotBlank(equipment.getCity()) && !(cityList.contains(equipment.getCity()))) {
            return MessageBean.fail("所选城市信息错误");
        }
        equipmentDao.updateEquipment(equipment);
        return MessageBean.success("修改成功");
    }
}
