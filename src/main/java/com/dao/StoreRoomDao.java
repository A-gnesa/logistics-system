package com.dao;

import com.annotation.ReturnCheck;
import com.dao.provide.StoreRoomProvider;
import com.enity.StoreRoom;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

/**
 * @Author 赵冠乔
 * @Date 2022/4/10
 */
@Mapper
public interface StoreRoomDao {
    /**
     * 根据条件查询
     *
     * @param storeRoom storeRoom
     * @return ArrayList<StoreRoom>
     */
    @SelectProvider(type = StoreRoomProvider.class, method = "selectByCondition")
    ArrayList<StoreRoom> query(StoreRoom storeRoom);

    /**
     * 添加库存
     *
     * @param storeRoom storeRoom
     * @return 影响条数
     */
    @ReturnCheck
    @Insert("insert into storeroom set no = '${storeRoom.no}',name = '${storeRoom.name}',inventory = ${storeRoom.inventory},max_Inventory = ${storeRoom.maxInventory},manager_no = '${storeRoom.managerNo}',city = '${storeRoom.city}'")
    int addStoreRoom(@Param("storeRoom") StoreRoom storeRoom);

    /**
     * 更改库存信息
     * @param storeRoom storeRoom
     * @return 影响条数
     */
    @ReturnCheck
    @InsertProvider(type = StoreRoomProvider.class, method = "update")
    int updateStoreRoom(StoreRoom storeRoom);

    /**
     * 自增库存
     * @param storeRoom 库存编码
     * @return 影响条数
     */
    @ReturnCheck
    @Update("UPDATE storeroom SET update_time = now(),inventory = inventory + 1 WHERE no = '${storeRoom.no}'")
    int addInventory(@Param("storeRoom") StoreRoom storeRoom);

    /**
     * 自减库存
     * @param storeRoom 库存编码
     * @return 影响条数
     */
    @ReturnCheck
    @Update("UPDATE storeroom SET update_time = now(),inventory = inventory - 1 WHERE no = '${storeRoom.no}'")
    int subtractInventory(@Param("storeRoom") StoreRoom storeRoom);


}
