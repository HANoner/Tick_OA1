package com.qianfeng.dao;

import com.qianfeng.entity.contect;

public interface contectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(contect record);

    int insertSelective(contect record);

    contect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(contect record);

    int updateByPrimaryKey(contect record);
}