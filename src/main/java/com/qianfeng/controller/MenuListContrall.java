package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.user;
import com.qianfeng.service.menuListService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VMenuList;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author feng
 * @create 2019-04-13 下午 3:55
 */
@RestController
@RequestMapping("menu")
@RequiresPermissions("fa-shield")
public class MenuListContrall {
    @Autowired
    private menuListService menuListService;


    @RequestMapping("list.do")
    public JsonBean findlist(String uno){
        List<VMenuList> all = menuListService.findAll(uno);
        return JsonUtils.createJsonBean(1,all);
    }


}
