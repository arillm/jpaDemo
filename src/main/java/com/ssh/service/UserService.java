package com.ssh.service;

import com.ssh.entity.SysUserEntity;
import com.ssh.service.base.BaseService;

/**
 * @Author lt
 * @create 2018-03-31 14:45
 * @VERSION 1.0
 */
public interface UserService extends BaseService<SysUserEntity>{

    SysUserEntity getSysUserByName(String name);



}
