package com.qianfeng.dao;

import com.qianfeng.entity.roleauthorityKey;

public interface roleauthorityMapper {
    int deleteByPrimaryKey(roleauthorityKey key);

    int insert(roleauthorityKey record);

    int insertSelective(roleauthorityKey record);
}