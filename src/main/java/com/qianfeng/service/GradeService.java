package com.qianfeng.service;

import com.qianfeng.Vo.VGrade;
import com.qianfeng.entity.grade;

import java.util.List;
import java.util.Map;

public interface GradeService {

    public Map<String, Object> findGradeAll(Integer page, Integer pageSize);

    public void deleteGradeById(Integer id);

    public void updateGrade(grade grade);

    public void addGrade(grade grade);

}
