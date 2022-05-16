package com.service;

import com.annotation.ReturnCheck;
import com.dao.provide.CityProvider;
import com.enity.City;
import com.enity.MessageBean;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Date 2022/5/15 5:44 PM
 * @Author 赵冠乔
 */
public interface CityService {
    /**
     * 增加城市
     *
     * @param city city
     * @return 影响条数
     */
    MessageBean insertCity(City city);

    /**
     * 获取所有城市信息
     * @return 所有城市信息
     */
    MessageBean findAllCity();

}
