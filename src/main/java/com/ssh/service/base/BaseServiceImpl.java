package com.ssh.service.base;

import com.ssh.dao.Base.IBaseDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author lt
 * @create 2018-04-10 10:40
 * @VERSION 1.0
 */
@Service
public class BaseServiceImpl<T> implements BaseService<T> {

    @Resource(name = "baseDaoImpl")
    private IBaseDao baseDao;

    @Override
    public T get(Integer id) {
        return (T)baseDao.get(id);
    }

    @Override
    public T get(String name) {
        return (T)baseDao.get(name);
    }

    @Override
    public void save(T entity) {
        baseDao.save(entity);
    }

    @Override
    public void delete(T entity) {
        baseDao.delete(entity);
    }

    @Override
    public void update(T entity) {
        baseDao.update(entity);
    }
}
