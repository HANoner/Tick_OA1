package com.qianfeng.dao;

import com.qianfeng.entity.authority;

public interface authorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(authority record);

    int insertSelective(authority record);

    authority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(authority record);

    int updateByPrimaryKey(authority record);
}