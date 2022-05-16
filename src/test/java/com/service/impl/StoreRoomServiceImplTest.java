package com.service.impl;

import com.enity.StoreRoom;
import com.enity.StoreRoomVO;
import com.service.StoreRoomService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Date 2022/5/15 4:03 PM
 * @Author 赵冠乔
 */
@SpringBootTest
class StoreRoomServiceImplTest {
    @Resource
    StoreRoomService storeRoomService;
    @Test
    void query() {
        System.out.println(storeRoomService.query(new StoreRoom()));
    }
}