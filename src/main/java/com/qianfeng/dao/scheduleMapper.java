package com.qianfeng.dao;

import com.qianfeng.entity.schedule;

public interface scheduleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(schedule record);

    int insertSelective(schedule record);

    schedule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(schedule record);

    int updateByPrimaryKey(schedule record);
}