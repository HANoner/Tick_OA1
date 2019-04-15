package com.qianfeng.dao;

import com.qianfeng.entity.course;

import java.util.List;

public interface courseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(course record);

    int insertSelective(course record);

    course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(course record);

    int updateByPrimaryKey(course record);

    public void addCourse(course course);

    public List<course> findAll();

}