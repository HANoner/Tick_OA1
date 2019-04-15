package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.course;
import com.qianfeng.service.CourseService;
import com.qianfeng.utils.JsonUtils;
import org.apache.ibatis.ognl.DynamicSubscript;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import static org.apache.ibatis.ognl.DynamicSubscript.all;

/**
 * @author feng
 * @create 2019-04-15 上午 10:18
 */
@RestController
@RequestMapping("course")
@RequiresPermissions("fa-graduation-cap")
public class CourseServlet {
    @Autowired
    private CourseService courseService;


    @RequestMapping("add.do")
    public JsonBean addCourse(String name,String createdate,int week,int type){
      course c = new course();
       c.setName(name);
       c.setWeek(week);
       c.setType(type);
       if (createdate != null && createdate != ""){
           try {
               c.setCreatedate(new SimpleDateFormat("yyyy-MM-dd").parse(createdate));
           } catch (ParseException e) {
               e.printStackTrace();
           }
       }
        courseService.addCourse(c);
        return JsonUtils.createJsonBean(1,null);
    }
    @RequestMapping("list.do")
    public Map findAll(int page,int limit){
        Map<String, Object> all = courseService.findAll(page, limit);
        return all;

    }
}
