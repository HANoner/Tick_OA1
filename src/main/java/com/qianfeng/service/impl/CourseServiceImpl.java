package com.qianfeng.service.impl;

import com.qianfeng.dao.courseMapper;
import com.qianfeng.entity.course;
import com.qianfeng.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
