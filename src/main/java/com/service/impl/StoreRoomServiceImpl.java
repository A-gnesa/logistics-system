package com.service.impl;

import com.dao.CityDao;
import com.dao.StoreRoomDao;
import com.dao.UserDao;
import com.enity.MessageBean;
import com.enity.StoreRoom;
import com.enity.StoreRoomVO;
import com.enums.ErrorCodeEnum;
import com.service.CityService;
import com.service.StoreRoomService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author 赵冠乔
 * @Date 2022/4/11
 */
@Service
public class StoreRoomServiceImpl implements StoreRoomService {
    @Resource
    StoreRoomDao storeRoomDao;
    @Resource
    UserDao userDao;
    @Resource
    CityDao cityDao;

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    @Override
    public MessageBean query(StoreRoom storeRoom) {
        ArrayList<StoreRoom> query = storeRoomDao.query(storeRoom);
        ArrayList<StoreRoomVO> storeRoomVOS = new ArrayList<>();
        query.forEach(s -> storeRoomVOS.add(new StoreRoomVO(s).setManagerName(userDao.findUserByNo(s.getManagerNo()).getName())));
        return MessageBean.success(storeRoomVOS);
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
        List<String> cityList = new ArrayList<>();
        cityDao.findAllCity().forEach(c -> cityList.add(c.getName()));
        if (!(cityList.contains(storeRoom.getCity()))) {
            return MessageBean.fail("所选城市信息错误");
        }
        cityList.clear();
        ArrayList<StoreRoom> list = storeRoomDao.query(new StoreRoom().setCity(storeRoom.getCity()));
        list.forEach(s -> cityList.add(s.getCity()));
        if (!(list.isEmpty())) {
            return MessageBean.fail("所选城市信息重复");
        }
        storeRoomDao.addStoreRoom(storeRoom);
        return MessageBean.success();
    }

    @Override
    public MessageBean updateStoreRoom(StoreRoom storeRoom) {
        List<String> cityList = new ArrayList<>();
        cityDao.findAllCity().forEach(c -> cityList.add(c.getName()));
        if (Strings.isNotBlank(storeRoom.getCity()) && !(cityList.contains(storeRoom.getCity()))) {
            return MessageBean.fail("所选城市信息错误");
        }
        storeRoomDao.updateStoreRoom(storeRoom);
        return MessageBean.success();
    }
}
