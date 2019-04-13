package com.qianfeng.dao;

import com.qianfeng.entity.papers;

public interface papersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(papers record);

    int insertSelective(papers record);

    papers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(papers record);

    int updateByPrimaryKey(papers record);
}