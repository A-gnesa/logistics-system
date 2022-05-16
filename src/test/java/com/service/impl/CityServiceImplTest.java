package com.service.impl;

import com.service.CityService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Date 2022/5/15 9:15 PM
 * @Author 赵冠乔
 */
@SpringBootTest
class CityServiceImplTest {
    @Resource
    CityService cityService;
    @Test
    void findAllCity() {
        System.out.println(cityService.findAllCity());
    }
}