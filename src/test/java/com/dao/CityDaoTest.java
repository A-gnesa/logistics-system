package com.dao;

import com.enity.City;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Date 2022/5/15 1:53 PM
 * @Author 赵冠乔
 */
@SpringBootTest
class CityDaoTest {
    @Resource
    CityDao cityDao;
    @Test
    void insertCity() {
        cityDao.insertCity(new City().setName("哈尔滨"));
    }

    @Test
    void findAllCity() {
        System.out.println(cityDao.findAllCity());
    }
}