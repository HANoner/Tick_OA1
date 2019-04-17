package com.qianfeng.dao;

import com.qianfeng.entity.authority;

import java.util.List;

public interface authorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(authority record);

    int insertSelective(authority record);

    authority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(authority record);

    int updateByPrimaryKey(authority record);

    public List<authority> findAuthoritylist();
}