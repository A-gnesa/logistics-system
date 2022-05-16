package com.service.impl;

import com.dao.CityDao;
import com.dao.EquipmentDao;
import com.enity.City;
import com.enity.CityVO;
import com.enity.MessageBean;
import com.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2022/5/15 5:44 PM
 * @Author 赵冠乔
 */
@Service
public class CityServiceImpl implements CityService {
    @Resource
    CityDao cityDao;
    @Resource
    EquipmentDao equipmentDao;

    @Override
    public MessageBean insertCity(City city) {
        List<String> cityList = new ArrayList<>();
        cityDao.findAllCity().forEach(c -> cityList.add(c.getName()));
        if (cityList.contains(city.getName())){
            return MessageBean.fail("城市重复");
        }
        cityDao.insertCity(city);
        return MessageBean.success("添加成功");
    }

    @Override
    public MessageBean findAllCity() {
        List<City> allCity = cityDao.findAllCity();
        List<CityVO> list = new ArrayList<>();
        allCity.forEach(c -> list.add(new CityVO(c).setAirNumber(equipmentDao.countAirByCity(c.getName())).setCarNumber(equipmentDao.countCarByCity(c.getName()))));
        return MessageBean.success(list);
    }


}
