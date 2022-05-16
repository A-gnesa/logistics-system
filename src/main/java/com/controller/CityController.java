package com.controller;

import com.enity.City;
import com.enity.Group;
import com.enity.MessageBean;
import com.service.CityService;
import com.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Date 2022/5/16 11:24 AM
 * @Author 赵冠乔
 */
@Api(value = "城市Controller", tags = {"城市访问接口"})
@RestController
@RequestMapping("/city")
public class CityController {
    @Resource
    CityService cityService;

    /**
     * 增加城市
     *
     * @param city city
     * @return 影响条数
     */
    @PostMapping("/insertCity")
    @ApiOperation(value = "增加城市", httpMethod = "POST", notes = "传城市名称 不能重复")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 201, message = "失败")
            , @ApiResponse(code = 9999, message = "系统错误"), @ApiResponse(code = 9001, message = "参数有误"), @ApiResponse(code = 9002, message = "请求超时")})
    MessageBean insertCity(@Validated(Group.Insert.class)City city){
        return cityService.insertCity(city);
    }

    /**
     * 获取所有城市信息
     * @return 所有城市信息
     */
    @GetMapping("/findAllCity")
    @ApiOperation(value = "获取所有城市信息", httpMethod = "Get", notes = "没参数")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 201, message = "失败")
            , @ApiResponse(code = 9999, message = "系统错误"), @ApiResponse(code = 9001, message = "参数有误"), @ApiResponse(code = 9002, message = "请求超时")})
    MessageBean findAllCity(){
        return cityService.findAllCity();
    }
}
