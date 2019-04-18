package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.dao.userMapper;
import com.qianfeng.entity.role;
import com.qianfeng.entity.user;
import com.qianfeng.service.AuthorityService;
import com.qianfeng.service.RoleService;
import com.qianfeng.service.UserLimitService;
import com.qianfeng.utils.JsonUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @create 2019-04-15 下午 5:09
 */
@RestController
@RequestMapping("Authority")
@RequiresPermissions("fa-shield")
public class AuthorityController {
    @Autowired
    private UserLimitService userLimitService;
        /*菜单 -》 权限管理 -》的控制器 */
    @Autowired
    private userMapper userMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthorityService authorityService;

    @RequestMapping("/search.do")
    public Map findSearch(String no,Integer flag,int page,int limit){
        Map search = userLimitService.findSearch(no, flag, page, limit);
        return  search;
    }
    @RequestMapping("/userdel.do")
    public JsonBean userDeleteById(int id){
        /*角色权限下的删除操作*/
        roleService.roleDeleteById(id);
        return JsonUtils.createJsonBean(1000,null);
    }

    @RequestMapping("userroleedit.do")
    public JsonBean userRoleEdit(){
    return  null;
    }

    @RequestMapping("/roleall.do")
    public Map roleAll(int page,int limit,String no){
        Map map = roleService.roleAll(no);
        return  map;
    }

    @RequestMapping("authoritylist.do")
    public  Map findAuthoritylist(int limit,int page){
        Map authorityList = authorityService.findAuthorityList(page, limit);
        return authorityList;
    }

    @RequestMapping("role.do")
    public List findRole(){

        return  null;
    }
}
