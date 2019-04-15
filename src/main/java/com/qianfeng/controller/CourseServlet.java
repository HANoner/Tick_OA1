package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.course;
import com.qianfeng.service.CourseService;
import com.qianfeng.utils.JsonUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author feng
 * @create 2019-04-15 上午 10:18
 */
@RestController
@RequestMapping("course")
public class CourseServlet {
    @Autowired
    private CourseService courseService;
    @RequiresPermissions("fa-graduation-cap")

    @RequestMapping("add.do")
    public JsonBean addCourse(course course){
        courseService.insertSelective(course);
        return JsonUtils.createJsonBean(1,null);
    }
}
