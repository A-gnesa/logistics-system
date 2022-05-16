package com.dao;

import com.enity.StoreRoom;
import com.enity.StoreRoomVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Date 2022/5/15 4:15 PM
 * @Author 赵冠乔
 */
@SpringBootTest
class StoreRoomDaoTest {
    @Resource
    StoreRoomDao storeRoomDao;

    StoreRoom storeRoom = new StoreRoom().setNo("1e5c841a-fc5c-493c-a30a-77518aad11e1");
    @Test
    void addInventory() {
        storeRoomDao.addInventory(storeRoom);
        System.out.println(storeRoomDao.query(storeRoom));
    }

    @Test
    void subtractInventory() {
        storeRoomDao.subtractInventory(storeRoom);
        System.out.println(storeRoomDao.query(storeRoom));
    }
}