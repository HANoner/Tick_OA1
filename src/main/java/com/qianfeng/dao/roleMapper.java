package com.qianfeng.dao;

import com.qianfeng.entity.role;
import com.qianfeng.vo.VMenuList;

import java.util.List;

public interface roleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(role record);

    int insertSelective(role record);

    role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(role record);

    int updateByPrimaryKey(role record);
    // menu
    public List<VMenuList> findAll(String uno);
}