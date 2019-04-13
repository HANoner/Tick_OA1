package com.qianfeng.dao;

import com.qianfeng.entity.loginlog;

public interface loginlogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(loginlog record);

    int insertSelective(loginlog record);

    loginlog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(loginlog record);

    int updateByPrimaryKey(loginlog record);
}