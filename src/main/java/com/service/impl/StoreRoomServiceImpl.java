package com.service.impl;

import com.dao.StoreRoomDao;
import com.enity.MessageBean;
import com.enity.StoreRoom;
import com.service.StoreRoomService;

import javax.annotation.Resource;

/**
 * @Author 赵冠乔
 * @Date 2022/4/11
 */
public class StoreRoomServiceImpl implements StoreRoomService {
    @Resource
    StoreRoomDao storeRoomDao;

    @Override
    public MessageBean query(StoreRoom storeRoom) {
        return MessageBean.success(storeRoomDao.query(storeRoom));
    }

    @Override
    public MessageBean addStoreRoom(StoreRoom storeRoom) {
        storeRoomDao.addStoreRoom(storeRoom);
        return MessageBean.success();
    }

    @Override
    public MessageBean updateStoreRoom(StoreRoom storeRoom) {
        storeRoomDao.updateStoreRoom(storeRoom);
        return MessageBean.success();
    }
}
