package com.ssh.controller;

import com.ssh.common.utils.MD5Util;
import com.ssh.entity.SysUserEntity;
import com.ssh.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author lt
 * @create 2018-04-14 14:08
 * @VERSION 1.0
 */


@Controller
@RequestMapping("/user")
public class IndexController {


    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String tologin(){
        return "login";
    }


    @RequestMapping("/dologin")
    @ResponseBody
    public String tologin(SysUserEntity sysUserEntity){
        try {
            SysUserEntity user = userService.getSysUserByName(sysUserEntity.getSysUser());
            if (user.getPassword().equals(sysUserEntity.getPassword())){
                return "success";
            }else{
                return "faile";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "faile";
        }
    }

    @RequestMapping("/dologin2")
    @ResponseBody
    public String shiroLogin(SysUserEntity user){
        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());//如果原来有的话，就退出
        //登录后存放进shiro token
        UsernamePasswordToken token=new UsernamePasswordToken(user.getSysUser(),user.getPassword());
        Subject subject=SecurityUtils.getSubject();
        try {
            subject.login(token);
            System.out.println("登录成功！");
            //登录成功后会跳转到successUrl配置的链接，不用管下面返回的链接
            return "success";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("登录失败！");
            return "faile";
        }
    }




}
