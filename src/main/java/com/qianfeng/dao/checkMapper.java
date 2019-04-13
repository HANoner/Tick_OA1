package com.qianfeng.dao;

import com.qianfeng.entity.check;

public interface checkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(check record);

    int insertSelective(check record);

    check selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(check record);

    int updateByPrimaryKey(check record);
}