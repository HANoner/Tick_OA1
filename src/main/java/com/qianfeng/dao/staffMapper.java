package com.qianfeng.dao;

import com.qianfeng.entity.staff;

public interface staffMapper {
    int deleteByPrimaryKey(String no);

    int insert(staff record);

    int insertSelective(staff record);

    staff selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(staff record);

    int updateByPrimaryKey(staff record);
}