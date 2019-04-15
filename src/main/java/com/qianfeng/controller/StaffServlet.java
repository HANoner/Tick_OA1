package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.staff;
import com.qianfeng.service.StaffService;
import com.qianfeng.utils.JsonUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class StaffServlet {
    @Autowired
    private StaffService staffService;

    @RequestMapping("/staff/list.do")
    @RequiresPermissions("fa-users")
    public Map<String, Object> findAllGrade(Integer page, Integer limit){
        Integer pageSize = limit;
        if(pageSize ==null){
            pageSize=10;
        }
        Map<String, Object> map = staffService.findAllGrade(page,pageSize);
        return map;
    }
}
