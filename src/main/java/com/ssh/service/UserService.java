package com.ssh.service;

import com.ssh.dto.LoginUserDTO;
import com.ssh.entity.SysUserEntity;

/**
 * @Author lt
 * @create 2018-03-31 14:45
 * @VERSION 1.0
 */
public interface UserService {

    SysUserEntity getSysUserByName(String name);



}
