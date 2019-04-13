package com.qianfeng.dao;

import com.qianfeng.entity.ddress;

public interface ddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ddress record);

    int insertSelective(ddress record);

    ddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ddress record);

    int updateByPrimaryKey(ddress record);
}