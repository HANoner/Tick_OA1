package com.qianfeng.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 * @author feng
 * @create 2019-04-15 上午 8:19
 */
public class SessionUtil {
//    获取session的工具类
    private  static Session session = null;

    public static  Session getSession(){
        return  session;
    }
    public static void  setSession(Session session){

        SessionUtil.session = session;
    }
}
