package com.dao.provide;

import com.enity.City;

/**
 * @Date 2022/5/15 1:50 PM
 * @Author 赵冠乔
 */
public class CityProvider {
    /**
     * 插入语句
     *
     * @param city user
     * @return sql
     */
    public String insertCity(City city) {
        return "INSERT INTO city SET " + "name = '" + city.getName() + "'";
    }

}
