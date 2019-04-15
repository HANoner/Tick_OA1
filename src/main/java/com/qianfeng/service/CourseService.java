package com.qianfeng.service;

import com.qianfeng.entity.course;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @create 2019-04-15 上午 10:16
 */
public interface CourseService {
    public void  insertSelective(course record);
    public void addCourse(course course);

    public Map<String,Object> findAll(int page, int limit);

    public  void deleteById(int id);

    public void  updateByPrimaryKeySelective(course record);
}
