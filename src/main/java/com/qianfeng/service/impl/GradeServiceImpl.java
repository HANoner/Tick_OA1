package com.qianfeng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.vo.VGrade;
import com.qianfeng.dao.gradeMapper;
import com.qianfeng.entity.grade;
import com.qianfeng.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private gradeMapper gradeDao;
    @Override
    public Map<String, Object> findGradeAll(Integer page, Integer pageSize) {



        PageHelper.startPage(page,pageSize);
        List<VGrade>  list = gradeDao.findAllGrades();
        Map<String, Object> map = new HashMap<>();
        long count = ((Page)list).getTotal();
            map.put("code", 0);
            map.put("msg","");
            map.put("count",count);
            map.put("data",list);

        return map;
    }

    @Override
    public void deleteGradeById(Integer id) {
        gradeDao.deleteGrade(id);

    }

    @Override
    public void updateGrade(grade grade) {
        gradeDao.updateByPrimaryKeySelective(grade);
    }

    @Override
    public void addGrade(grade grade) {
        gradeDao.insert(grade);
    }
}
