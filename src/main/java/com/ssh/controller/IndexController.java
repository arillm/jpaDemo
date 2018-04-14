package com.ssh.controller;

import com.ssh.entity.SysUserEntity;
import com.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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


}
