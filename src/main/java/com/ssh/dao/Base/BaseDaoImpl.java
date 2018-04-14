package com.ssh.dao.Base;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @Author lt
 * @create 2018-03-31 11:17
 * @VERSION 1.0
 */

@Repository
public class BaseDaoImpl<T> implements IBaseDao<T> {

    protected SessionFactory sessionFactory;
    protected Class<T> Classz;




    /***********srpingdata jpa******************************************************************************/




    /***********JdbcTemplate jpa******************************************************************************/
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Override
    public List getDateBysqlTemplate(String sql) {
        return null;
    }

    @Override
    public <T> List<T> getDateBysqlTemplate(Class<T> entityClass, String sql) {
        return null;
    }



    /***********hibernate jpa******************************************************************************/
    @Resource(name="sessionFactory")
    public void setHibernateSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public T get(Integer id) {
        return (T) getSession().get(Classz, id);
    }

    @Override
    public T get(String name) {
        Criteria c = getSession().createCriteria(Classz).add(Restrictions.like("sysUser", name));
        List<T> list = c.list();
        return list.get(0);
    }

    @Override
    public void save(T entity) {
        getSession().save(entity);
        getSession().flush();
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
        getSession().flush();
    }

    @Override
    public void update(T entity) {
        getSession().update(entity);
        getSession().flush();
    }
    /************hibernate jpa end*************************************************************************************/



    @Override
    public List getDateByHqlTemplate(String hql) {
        return null;
    }

    @Override
    public <T> List<T> getDateByHqlTemplate(Class<T> entityClass, String Hql) {
        return null;
    }











    /************************************************************/

    public BaseDaoImpl() {
        // 通过反射机制获取子类传递过来的实体类的类型信息
//        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
//        this.Classz = (Class) type.getActualTypeArguments()[0];
        this.Classz = null;
        Class<?> c = getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.Classz = (Class<T>) parameterizedType[0];
        }
    }

}
