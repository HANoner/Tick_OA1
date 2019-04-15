package com.qianfeng.controller;

import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.user;
import com.qianfeng.service.UserService;
import com.qianfeng.utils.JsonUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author feng
 * @create 2019-04-13 下午 10:19
 */
@RestController
@RequestMapping("user")
public class UserContrall {
    @Autowired
    private UserService userService;
    /*过滤器里面配置过登陆可访问*/
    @RequestMapping("user.do")
    public JsonBean findUser (){
        user user = userService.findUser();
        return JsonUtils.createJsonBean(1,user);

    }
}
