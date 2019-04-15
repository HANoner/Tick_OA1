package com.qianfeng.dao;

import com.qianfeng.vo.VGrade;
import com.qianfeng.entity.grade;

import java.util.List;

public interface gradeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(grade record);

    int insertSelective(grade record);

    grade selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(grade record);

    int updateByPrimaryKey(grade record);

    public List<VGrade> findAllGrades();

    public void deleteGrade(Integer id);
}