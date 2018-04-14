package com.ssh.controller;

import com.ssh.entity.SysUserEntity;
import com.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lt
 * @create 2018-03-31 10:16
 * @VERSION 1.0
 */
@RestController
public class TestController {


    @Autowired
    private UserService userService;


    @GetMapping("/test")
    public String testdemo(){

        return "this is test!";
    }


    @GetMapping("/test2")
    public SysUserEntity testdemo2(){
        SysUserEntity admin = userService.getSysUserByName("admin");
        return admin;
    }


    @GetMapping("/test3")
    public void testdemo3(){
        SysUserEntity admin2 = new SysUserEntity(2, "admin2", "123456", "1", 0);
        userService.save(admin2);
    }


    @GetMapping("/test4")
    public void testdemo4(){
        SysUserEntity admin = userService.getSysUserByName("admin2");
        admin.setPassword("111111111");
        userService.update(admin);
    }

}
