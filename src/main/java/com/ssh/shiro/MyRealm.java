package com.ssh.shiro;


import com.ssh.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author lt
 * @create 2018-03-31 15:00
 * @VERSION 1.0
 */
public class MyRealm extends AuthorizingRealm{

    @Autowired
    private UserService UserService;


    // 为当前登陆成功的用户授予权限和角色，已经登陆成功了
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    // 验证当前登录的用户，获取认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }



}
