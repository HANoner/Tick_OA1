package com.qianfeng.service;

import com.qianfeng.entity.course;

/**
 * @author feng
 * @create 2019-04-15 上午 10:16
 */
public interface CourseService {
    public void  insertSelective(course record);
    public void addCourse(course course);
}
