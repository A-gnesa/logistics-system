package com.service.impl;

import com.annotation.ReturnCheck;
import com.dao.CityDao;
import com.dao.EquipmentDao;
import com.dao.OrderDao;
import com.dao.StoreRoomDao;
import com.enity.*;
import com.enums.EquipmentStateEnum;
import com.enums.ErrorCodeEnum;
import com.enums.OrderStateEnum;
import com.service.OrderService;
import com.service.StoreRoomService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @Author 赵冠乔
 * @Date 2022/4/11
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderDao orderDao;
    @Resource
    EquipmentDao equipmentDao;
    @Resource
    StoreRoomDao storeRoomDao;
    @Resource
    CityDao cityDao;

    @Override
    public MessageBean query(Order order) {
        ArrayList<OrderVO> list = new ArrayList<>();
        ArrayList<Order> query = orderDao.query(order);
        if (!(query.isEmpty())) {
            for (Order o : query) {
                String transportNo = o.getTransportNo();
                if (Strings.isNotBlank(transportNo)) {
                    List<Equipment> equipment = equipmentDao.findEquipment(new Equipment().setNo(transportNo));
                    if (!(equipment.isEmpty())) {
                        list.add(new OrderVO(o).setEquipment(equipment.get(0)));
                        continue;
                    }
                }
                list.add(new OrderVO(o));
            }
        }
        return MessageBean.success(list);
    }

    @Override
    public MessageBean createOrder(Order order) {
        List<String> allCity = new ArrayList<>();
        cityDao.findAllCity().forEach(c -> allCity.add(c.getName()));
        if (!(allCity.contains(order.getStartingPoint()))){
            return MessageBean.fail("始发地没有仓库 联系管理员进行添加");
        }
        if (!(allCity.contains(order.getDestination()))){
            return MessageBean.fail("目的地没有仓库 联系管理员进行添加");
        }
        order.setNo(UUID.randomUUID().toString());
        order.setState(OrderStateEnum.CREATE);
        orderDao.createOrder(order);
        return MessageBean.success();
    }

    @Override
    public MessageBean updateOrder(Order order) {
        orderDao.updateOrder(order);
        return MessageBean.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MessageBean switchOrderStateToShipments(Order order) {
        List<Equipment> equipmentList = equipmentDao.findEquipment(new Equipment().setNo(order.getTransportNo()));
        if (equipmentList.isEmpty()) {
            return MessageBean.fail("运输设备信息错误 重新选择");
        }
        ArrayList<Order> orders = orderDao.query(new Order().setNo(order.getNo()));
        if (orders.isEmpty()){
            return MessageBean.fail("订单信息错误 重新选择");
        }
        ArrayList<StoreRoom> query = storeRoomDao.query(new StoreRoom().setName(orders.get(0).getStartingPoint()));
        if (query.isEmpty()){
            return MessageBean.fail("始发地区没有库存");
        }
        if (query.get(0).getInventory() <= 0){
            return MessageBean.fail("始发地区没有库存不足 联系管理员补货");
        }
        storeRoomDao.subtractInventory(query.get(0));

        MessageBean result = updateEquipmentState(equipmentList.get(0));
        if (ErrorCodeEnum.NO.getCode().equals(result.getCode())){
            return MessageBean.fail("运输设备信息有误");
        }

        equipmentDao.updateEquipment(equipmentList.get(0).setCity(order.getDestination()));
        orderDao.switchOrderStateToShipments(orders.get(0));
        return MessageBean.success("修改成功");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MessageBean switchOrderStateToReceived(Order order) {
        ArrayList<Order> orders = orderDao.query(new Order().setNo(order.getNo()));
        if (orders.isEmpty()){
            return MessageBean.fail("订单信息错误 重新选择");
        }

        List<Equipment> equipmentList = equipmentDao.findEquipment(new Equipment().setNo(orders.get(0).getTransportNo()));
        if (equipmentList.isEmpty()) {
            return MessageBean.fail("运输设备信息错误 重新选择");
        }

        MessageBean result = updateEquipmentState(equipmentList.get(0));
        if (ErrorCodeEnum.NO.getCode().equals(result.getCode())){
            return MessageBean.fail("运输设备信息有误");
        }
        equipmentDao.updateEquipment(equipmentList.get(0).setCity(order.getDestination()));

        ArrayList<StoreRoom> storeRooms = storeRoomDao.query(new StoreRoom().setName(orders.get(0).getDestination()));
        if (storeRooms.isEmpty()){
            return MessageBean.fail("库房信息错误");
        }
        if (storeRooms.get(0).getInventory() >= storeRooms.get(0).getMaxInventory()){
            return MessageBean.fail("到货地区 库存已满");
        }
        storeRoomDao.addInventory(storeRooms.get(0));
        orderDao.switchOrderStateToReceived(order);
        return MessageBean.success("修改成功");
    }

    private MessageBean updateEquipmentState(Equipment equipment) {
        if (Objects.isNull(equipment.getState())) {
            MessageBean.fail("状态为空 请重新访问再试");
        }
        if (EquipmentStateEnum.TRANSPORT.equals(equipment.getState())) {
            equipment.setState(EquipmentStateEnum.IDLE);
            return MessageBean.success(equipmentDao.updateState(equipment));
        }
        if (EquipmentStateEnum.IDLE.equals(equipment.getState())) {
            equipment.setState(EquipmentStateEnum.TRANSPORT);
        }
        return MessageBean.success(equipmentDao.updateState(equipment));

    }

}
