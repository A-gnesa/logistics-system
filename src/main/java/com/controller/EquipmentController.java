package com.controller;

import com.enity.Equipment;
import com.enity.Group;
import com.enity.MessageBean;
import com.service.EquipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Date 2022/5/16 11:43 AM
 * @Author 赵冠乔
 */
@Api(value = "设备Controller", tags = {"设备访问接口"})
@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Resource
    EquipmentService equipmentService;


    /**
     * 添加设备 传运输方式和名称
     * @param equipment 设备
     * @return 影响条数
     */
    @PostMapping("/insertEquipment")
    @ApiOperation(value = "添加设备", httpMethod = "POST", notes = "添加设备。传运输方式和名称和城市名称")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 201, message = "失败")
            , @ApiResponse(code = 9999, message = "系统错误"), @ApiResponse(code = 9001, message = "参数有误"), @ApiResponse(code = 9002, message = "请求超时")})
    MessageBean insertEquipment(@Validated(Group.Insert.class) Equipment equipment){
         return equipmentService.insertEquipment(equipment);
    }

    /**
     * 查询设备
     * @param equipment equipment
     * @return 设备列表
     */
    @PostMapping("/findEquipment")
    @ApiOperation(value = "查询设备", httpMethod = "POST", notes = "查询设备")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 201, message = "失败")
            , @ApiResponse(code = 9999, message = "系统错误"), @ApiResponse(code = 9001, message = "参数有误"), @ApiResponse(code = 9002, message = "请求超时")})
    MessageBean findEquipment(Equipment equipment){
        return equipmentService.findEquipment(equipment);
    }

    /**
     * 修改设备信息
     * @param equipment 设备编码
     * @return 影响条数
     */
    @PostMapping("/updateEquipment")
    @ApiOperation(value = "修改设备信息", httpMethod = "POST", notes = "修改设备信息 传编码")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 201, message = "失败")
            , @ApiResponse(code = 9999, message = "系统错误"), @ApiResponse(code = 9001, message = "参数有误"), @ApiResponse(code = 9002, message = "请求超时")})
    MessageBean updateEquipment(@Validated(Group.Update.class)Equipment equipment){
        return equipmentService.updateEquipment(equipment);
    }


}
