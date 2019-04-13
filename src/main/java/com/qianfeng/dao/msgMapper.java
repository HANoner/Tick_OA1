package com.qianfeng.dao;

import com.qianfeng.entity.msg;

public interface msgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(msg record);

    int insertSelective(msg record);

    msg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(msg record);

    int updateByPrimaryKeyWithBLOBs(msg record);

    int updateByPrimaryKey(msg record);
}