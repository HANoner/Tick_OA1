package com.qianfeng.dao;

import com.qianfeng.entity.user;

import java.util.List;

public interface userMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);

    /*以下  shiro 权限控制*/
    public String findPwdByName(String name);

    public List<String> findRoleByName(String name);

    public List<String> findPermisionByName(String name);


}