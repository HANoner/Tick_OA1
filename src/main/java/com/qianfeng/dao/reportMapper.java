package com.qianfeng.dao;

import com.qianfeng.entity.report;

public interface reportMapper {
    int deleteByPrimaryKey(Long id);

    int insert(report record);

    int insertSelective(report record);

    report selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(report record);

    int updateByPrimaryKeyWithBLOBs(report record);

    int updateByPrimaryKey(report record);
}