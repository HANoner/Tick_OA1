package com.qianfeng.dao;

import com.qianfeng.entity.student;

public interface studentMapper {
    int deleteByPrimaryKey(String no);

    int insert(student record);

    int insertSelective(student record);

    student selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(student record);

    int updateByPrimaryKey(student record);
}