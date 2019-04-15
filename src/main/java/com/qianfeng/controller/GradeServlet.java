package com.qianfeng.controller;

import com.qianfeng.Vo.VGrade;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.grade;
import com.qianfeng.service.GradeService;
import com.qianfeng.utils.JsonUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class GradeServlet {
    @Autowired
    private GradeService gradeService;
    @RequiresPermissions("fa-cube")

    @RequestMapping("/grade/list.do")
    public Map<String, Object> findByGradeAll(Integer page, Integer limit){
        Integer pageSize = limit;
        if(pageSize ==null){
            pageSize=10;
        }
        Map<String, Object> map = gradeService.findGradeAll(page, pageSize);

        return map;
    }
    @RequestMapping("/grade/delete.do")
    public JsonBean deleteGradeById(Integer id){

        try {
            gradeService.deleteGradeById(id);
            return JsonUtils.createJsonBean(1,null);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.createJsonBean(0,e.getMessage());
        }
    }

    @RequestMapping("/grade/update.do")
    public  JsonBean updateGrade(grade grade){
        gradeService.updateGrade(grade);
        return JsonUtils.createJsonBean(1,null);
    }
    @RequestMapping("/grade/add.do")
    public JsonBean addGrade(grade grade){
        grade.setCid(1);
        grade.setFlag(1);
        gradeService.addGrade(grade);
        return JsonUtils.createJsonBean(1,null);
    }

}
