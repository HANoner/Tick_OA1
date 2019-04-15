package com.qianfeng.service;

import com.qianfeng.entity.student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    public void StudentAdd(student student);

    public void AddStudengbatch(List<student> list);

    public Map<String, Object> findStudentAll(Integer page, Integer pageSize);

    public void deleteStudentByNo(String no);

    public void updateStudent(student student);
}
