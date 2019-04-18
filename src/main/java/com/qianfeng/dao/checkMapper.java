package com.qianfeng.dao;

import com.qianfeng.entity.check;

import java.util.List;

public interface checkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(check record);

    int insertSelective(check record);

    check selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(check record);

    int updateByPrimaryKey(check record);

    public List<check> findAll();

    public void processAdd(check check);

    public void processDelById(Integer id);


}