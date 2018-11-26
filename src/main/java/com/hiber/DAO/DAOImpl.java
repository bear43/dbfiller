package com.hiber.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOImpl implements DAO
{
    private static EntityManagerFactory manager = Persistence.createEntityManagerFactory("sample");

    protected EntityManager em = manager.createEntityManager();
    @Override
    public void create(Object obj)
    {
        if(!isOpen()) em = manager.createEntityManager();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

    @Override
    public <T> T read(T obj)
    {
        if(!isOpen()) em = manager.createEntityManager();
        return (T)em.find(obj.getClass(), obj);
    }

    @Override
    public void update(Object obj)
    {
        if(!isOpen()) em = manager.createEntityManager();
        em.getTransaction().begin();
        em.refresh(obj);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Object obj)
    {
        if(!isOpen()) em = manager.createEntityManager();
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
    }

    public void close()
    {
        em.close();
    }

    private boolean isOpen()
    {
        return em != null && em.isOpen();
    }
}
