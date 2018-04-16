package com.ssh.shiro;


import com.ssh.entity.SysUserEntity;
import com.ssh.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
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
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        /**
         * 获取权限和资源
         */
        System.out.println("获取了用户权限和资源！");
//        authorizationInfo.setRoles(UserService.findRoles(username));
//        authorizationInfo.setStringPermissions(UserService.findPermissions(username));
        return info;

    }

    // 验证当前登录的用户，获取认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("获取认证信息!");
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        //通过表单接收的用户名
        if(username!=null&&!"".equals(username)){
            SysUserEntity user=UserService.getSysUserByName(username);
            if(user!=null){
                return new SimpleAuthenticationInfo(user.getSysUser(),user.getPassword(),getName());
            }
        }
        return null;
    }




}
