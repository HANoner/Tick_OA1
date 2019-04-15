package com.qianfeng.dao;

import com.qianfeng.entity.student;
import com.qianfeng.vo.VStudentList;

import java.util.List;

public interface studentMapper {
    int deleteByPrimaryKey(String no);

    int insert(student record);

    int insertSelective(student record);

    student selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(student record);

    int updateByPrimaryKey(student record);

    public void addBatch(List<student> list);

    public List<VStudentList> findAllStudent();

    public void deleteStudent(String no);


}