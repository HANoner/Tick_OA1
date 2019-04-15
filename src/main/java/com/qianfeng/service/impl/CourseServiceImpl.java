package com.qianfeng.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.courseMapper;
import com.qianfeng.entity.course;
import com.qianfeng.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @create 2019-04-15 上午 10:16
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private courseMapper courseMapper;

    @Override
    public void insertSelective(course record) {
        courseMapper.insertSelective(record);
    }

    @Override
    public void addCourse(course course) {
        courseMapper.addCourse(course);
    }

    @Override
    public Map<String,Object> findAll(int page,int limit) {
        PageHelper.startPage(page, limit);
        List<course> all = courseMapper.findAll();
        long count =   ((Page)all).getTotal();
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",all);
        return map;
    }
}
