package com.qianfeng.dao;

import com.qianfeng.entity.province;

public interface provinceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(province record);

    int insertSelective(province record);

    province selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(province record);

    int updateByPrimaryKey(province record);
}