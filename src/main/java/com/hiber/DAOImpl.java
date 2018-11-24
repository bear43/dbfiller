package com.hiber;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DAOImpl implements DAO
{

    public int save(Object obj) throws Exception
    {
        int id;
        Session session = HibernateFactory.createSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        id = (Integer)session.save(obj);
        transaction.commit();
        session.close();
        return id;
    }

    public void update(Object obj) throws Exception
    {
        Session session = HibernateFactory.createSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(obj);
        transaction.commit();
        session.close();
    }

    public void delete(Object obj) throws Exception
    {
        Session session = HibernateFactory.createSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(obj);
        transaction.commit();
        session.close();
    }

    public<T> T findById(Class clazz, int id) throws Exception
    {
        Session session = HibernateFactory.createSessionFactory().openSession();
        T obj = (T)session.get(clazz, id);
        session.close();
        return obj;
    }

    public List<Object> findAll(Class clazz, String tablename) throws Exception
    {
        Session session = HibernateFactory.createSessionFactory().openSession();
        List obj = session.createQuery("from " + tablename).list();
        session.close();
        return obj;
    }
}
