package com.qianfeng.dao;

import com.qianfeng.entity.county;

public interface countyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(county record);

    int insertSelective(county record);

    county selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(county record);

    int updateByPrimaryKey(county record);
}