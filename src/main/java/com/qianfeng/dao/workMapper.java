package com.qianfeng.dao;

import com.qianfeng.entity.work;

public interface workMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(work record);

    int insertSelective(work record);

    work selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(work record);

    int updateByPrimaryKey(work record);
}