package com.qianfeng.service;

import com.qianfeng.common.JsonBean;
import com.qianfeng.dao.userMapper;
import com.qianfeng.entity.user;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author feng
 * @create 2019-04-11 上午 10:31
 */
public interface UserService {


    public  void login(String name, String password, boolean remaberme);

    public user findUser();


}
