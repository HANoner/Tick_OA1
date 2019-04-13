package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.student;
import com.qianfeng.entity.user;
import com.qianfeng.service.StudentService;
import com.qianfeng.service.UserService;
import com.qianfeng.utils.JsonUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈学生管理〉<br>
 * 〈和学生管理相关的service〉
 *
 * @author 作者:oner
 * @create 修改时间:2019/4/8
 * @since 1.0.0
 */
@RestController
@RequestMapping("student")
public class StudentManageServlrt {
    @Autowired
  private StudentService studentService;
@RequiresPermissions("fa-cube")
@RequestMapping("/studentadd.do")
    public JsonBean StudentAdd(student student){

    studentService.StudentAdd(student);

        return   JsonUtils.createJsonBean(1, null);
    }

}
