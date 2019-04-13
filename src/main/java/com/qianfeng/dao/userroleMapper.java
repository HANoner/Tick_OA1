package com.qianfeng.dao;

import com.qianfeng.entity.userroleKey;

public interface userroleMapper {
    int deleteByPrimaryKey(userroleKey key);

    int insert(userroleKey record);

    int insertSelective(userroleKey record);
}