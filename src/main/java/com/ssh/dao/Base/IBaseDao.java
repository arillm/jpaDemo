package com.ssh.dao.Base;

import java.util.List;

/**
 * @Author lt
 * @create 2018-03-31 10:17
 * @VERSION 1.0
 */
public interface IBaseDao<T> {

    T get(Integer id);
    T get(String name);

    void save(T entity);

    void delete(T entity);

    void update(T entity);



    List getDateByHqlTemplate(String hql);
    <T> List<T> getDateByHqlTemplate(Class<T> entityClass,String Hql);


    List getDateBysqlTemplate(String sql);
    <T> List<T> getDateBysqlTemplate(Class<T> entityClass,String sql);

}
