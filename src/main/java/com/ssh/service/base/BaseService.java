package com.ssh.service.base;

/**
 * @Author lt
 * @create 2018-04-10 10:39
 * @VERSION 1.0
 */
public interface BaseService<T> {


    T get(Integer id);
    T get(String name);

    void save(T entity);

    void delete(T entity);

    void update(T entity);


}
