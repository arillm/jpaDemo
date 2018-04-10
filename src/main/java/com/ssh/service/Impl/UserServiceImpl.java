package com.ssh.service.Impl;


import com.ssh.dao.SysUserDao;
import com.ssh.entity.SysUserEntity;
import com.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lt
 * @create 2018-03-31 14:45
 * @VERSION 1.0
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUserEntity getSysUserByName(String name) {
        return sysUserDao.get(name);
    }
}
