package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.service.UserLimitService;
import com.qianfeng.service.checkService;
import com.qianfeng.utils.JsonUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author feng
 * @create 2019-04-15 下午 4:16
 *
 *@author huaonan
 * @create 2019-04-18 下午 2:16
 */
@RestController
@RequestMapping("check")
@RequiresPermissions("fa-bell-o")
public class CheckController {
    @Autowired
    private checkService checkService;

    @RequestMapping("list.do")
    public Map findAll(int page,int limit){
        Map all = checkService.findAll(page, limit);
        return all;
    }
@RequestMapping("processdel.do")
    public JsonBean processDelById(Integer id , Integer filg){

        checkService.processDelById(id);
        return JsonUtils.createJsonBean(1000,null);
    }


}
