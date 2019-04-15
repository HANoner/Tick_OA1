package com.qianfeng.dao;

import com.qianfeng.entity.county;

import java.util.List;

public interface countyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(county record);

    int insertSelective(county record);

    county selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(county record);

    int updateByPrimaryKey(county record);

}