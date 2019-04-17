package com.qianfeng.controller;

import com.qianfeng.service.UserLimitService;
import com.qianfeng.service.checkService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author feng
 * @create 2019-04-15 下午 4:16
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


}
