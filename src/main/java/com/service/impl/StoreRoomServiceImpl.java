package com.service.impl;

import com.dao.StoreRoomDao;
import com.enity.MessageBean;
import com.enity.StoreRoom;
import com.enums.ErrorCodeEnum;
import com.service.StoreRoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author 赵冠乔
 * @Date 2022/4/11
 */
@Service
public class StoreRoomServiceImpl implements StoreRoomService {
    @Resource
    StoreRoomDao storeRoomDao;

    @Override
    public MessageBean query(StoreRoom storeRoom) {
        return MessageBean.success(storeRoomDao.query(storeRoom));
    }

    @Override
    public MessageBean addStoreRoom(StoreRoom storeRoom) {
        storeRoom.setNo(UUID.randomUUID().toString());
        if (storeRoom.getInventory() > storeRoom.getMaxInventory()) {
            return new MessageBean(ErrorCodeEnum.INVALID_PARAMS, "库存数不能超过最大库存数");
        }
        if (!storeRoomDao.query(new StoreRoom().setName(storeRoom.getName())).isEmpty()) {
            return new MessageBean(ErrorCodeEnum.INVALID_PARAMS, "库存名称重复");
        }
        storeRoomDao.addStoreRoom(storeRoom);
        return MessageBean.success();
    }

    @Override
    public MessageBean updateStoreRoom(StoreRoom storeRoom) {
        storeRoomDao.updateStoreRoom(storeRoom);
        return MessageBean.success();
    }
}
