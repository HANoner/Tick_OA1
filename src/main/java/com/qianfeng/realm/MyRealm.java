package com.qianfeng.realm;

import com.qianfeng.dao.userMapper;
import com.qianfeng.entity.user;
import com.qianfeng.utils.SessionUtil;
import com.qianfeng.vo.constant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Security;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.qianfeng.vo.constant.LONG_USER;

/**
 * @author feng
 * @create 2019-04-11 上午 10:05
 */
public class MyRealm extends AuthorizingRealm{

    @Autowired
    private userMapper userdao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String name = (String) principalCollection.getPrimaryPrincipal();

        List<String> roleByName = userdao.findRoleByName(name);
        List<String> permisionByName = userdao.findPermisionByName(name);
        Set<String> roleset = new HashSet<>(roleByName);
        Set<String> permset = new HashSet<>(permisionByName);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roleset);
        info.setStringPermissions(permset);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
         String username = (String)  token.getPrincipal();
         SecurityUtils.getSubject().getSession();

        user user = userdao.findPwdByName(username);
        SessionUtil.setSession(SecurityUtils.getSubject().getSession());
        Session session =  SessionUtil.getSession();
        session.setAttribute(constant.LONG_USER,user);
        SimpleAuthenticationInfo simpleAuthenticationInfo = null;
        if (user != null){

            simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getNo(), user.getPassword(), this.getName());
        }

        return simpleAuthenticationInfo;
    }
}
