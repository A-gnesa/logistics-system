package com.dao;

import com.annotation.ReturnCheck;
import com.dao.provide.CityProvider;
import com.dao.provide.UserProvider;
import com.enity.City;
import com.enity.User;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Date 2022/5/15 1:49 PM
 * @Author 赵冠乔
 */
@Mapper
public interface CityDao {
    /**
     * 增加城市
     *
     * @param city city
     * @return 影响条数
     */
    @InsertProvider(type = CityProvider.class, method = "insertCity")
    @ReturnCheck
    int insertCity(City city);

    /**
     * 获取所有城市信息
     * @return 所有城市信息
     */
    @Select("SELECT id,name,create_time,update_time FROM city;")
    List<City> findAllCity();


}
