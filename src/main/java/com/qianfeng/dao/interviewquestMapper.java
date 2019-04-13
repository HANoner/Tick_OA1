package com.qianfeng.dao;

import com.qianfeng.entity.interviewquest;

public interface interviewquestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(interviewquest record);

    int insertSelective(interviewquest record);

    interviewquest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(interviewquest record);

    int updateByPrimaryKeyWithBLOBs(interviewquest record);

    int updateByPrimaryKey(interviewquest record);
}