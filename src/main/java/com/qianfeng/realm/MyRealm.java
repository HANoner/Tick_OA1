package com.qianfeng.realm;

import com.qianfeng.dao.userMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
         String name = (String)  token.getPrincipal();
        System.out.println(name);
        String pwdByName = userdao.findPwdByName(name);
        System.out.println(pwdByName);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, pwdByName, this.getName());
        return simpleAuthenticationInfo;
    }
}
