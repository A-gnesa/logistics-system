package com.service;

import com.annotation.ReturnCheck;
import com.enity.MessageBean;
import com.enity.StoreRoom;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @Author 赵冠乔
 * @Date 2022/4/11
 */
public interface StoreRoomService {
    /**
     * 根据条件查询
     *
     * @param storeRoom storeRoom
     * @return MessageBean
     */
    MessageBean query(StoreRoom storeRoom);

    /**
     * 添加库存
     *
     * @param storeRoom storeRoom
     * @return MessageBean
     */
    MessageBean addStoreRoom(StoreRoom storeRoom);

    /**
     * 更改库存信息
     *
     * @param storeRoom storeRoom
     * @return MessageBean
     */
    MessageBean updateStoreRoom(StoreRoom storeRoom);


}
