package com.qianfeng.service.impl;

import com.qianfeng.common.JsonBean;
import com.qianfeng.dao.userMapper;
import com.qianfeng.entity.user;
import com.qianfeng.service.UserService;
import com.qianfeng.utils.SessionUtil;
import com.qianfeng.vo.constant;
import jdk.nashorn.internal.parser.Token;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import static com.qianfeng.vo.constant.LONG_USER;

/**
 * @author feng
 * @create 2019-04-11 上午 10:32
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private userMapper userMapper;

    @Override
    public void login(String name, String password, boolean remaberme) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(name, password);
        if (remaberme == true){
            usernamePasswordToken.setRememberMe(true);
        }
        Subject subject = SecurityUtils.getSubject();
        subject.login(usernamePasswordToken);
    }

    @Override
    public user findUser() {
        user us = (user)SessionUtil.getSession().getAttribute(constant.LONG_USER);
        user user = userMapper.findUser(us.getNo());
        return user;
    }


}

