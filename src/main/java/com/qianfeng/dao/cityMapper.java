package com.qianfeng.dao;

import com.qianfeng.entity.city;

public interface cityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(city record);

    int insertSelective(city record);

    city selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(city record);

    int updateByPrimaryKey(city record);
}