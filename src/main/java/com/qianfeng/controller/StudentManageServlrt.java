package com.qianfeng.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.grade;
import com.qianfeng.entity.student;
import com.qianfeng.service.StudentService;
import com.qianfeng.utils.ImportExcel;
import com.qianfeng.utils.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

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

    student.setFlag(1);
    studentService.StudentAdd(student);

        return   JsonUtils.createJsonBean(1, null);
    }


    @RequestMapping("/studentbatch.do")
    @ResponseBody
    public JsonBean importExcel(@RequestParam MultipartFile excelFile){

        try {
            String fileName = excelFile.getOriginalFilename();
            // 获取上传文件的输入流
            InputStream inputStream = excelFile.getInputStream();
            // 调用工具类中方法，读取excel文件中数据
            List<Map<String, Object>> sourceList = ImportExcel.readExcel(fileName, inputStream);

            // 将对象先转为json格式字符串，然后再转为List<SysUser> 对象
            ObjectMapper objMapper = new ObjectMapper();
            String infos = objMapper.writeValueAsString(sourceList);

            // json字符串转对象
            List<student> list = objMapper.readValue(infos, new TypeReference<List<student>>() {});

            // 批量添加
            studentService.AddStudengbatch(list);

            return JsonUtils.createJsonBean(1, null);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            return JsonUtils.createJsonBean(0, e.getMessage());
        }
    }

    @RequestMapping("/list.do")
    public Map<String, Object> findByStudentAll(Integer page, Integer limit){
        Integer pageSize = limit;
        if(pageSize ==null){
            pageSize=10;
        }
        Map<String, Object> map = studentService.findStudentAll(page, pageSize);

        return map;
    }
    @RequestMapping("/delete.do")
    public JsonBean deleteStudentByNo(String no){

        try {
            studentService.deleteStudentByNo(no);
            return JsonUtils.createJsonBean(1,null);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.createJsonBean(0,e.getMessage());
        }
    }

    @RequestMapping("/update.do")
    public  JsonBean updateStudent(student student){
        studentService.updateStudent(student);
        return JsonUtils.createJsonBean(1,null);
    }

}
