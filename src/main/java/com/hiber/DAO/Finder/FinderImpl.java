package com.hiber.DAO.Finder;

import com.hiber.DAO.DAOImpl;

import java.util.List;

public class FinderImpl extends DAOImpl implements Finder
{
    private String entityName;

    public FinderImpl(String entityName)
    {
        this.entityName = entityName;
    }

    @Override
    public Object findByID(long id)
    {
        Object ret;
        em.getTransaction().begin();
        ret = em.createQuery(String.format("from %s where id=%d", entityName, id)).getSingleResult();
        em.close();
        return ret;
    }

    @Override
    public List findAll()
    {
        List ret;
        em.getTransaction().begin();
        ret = em.createQuery("from " + entityName).getResultList();
        em.close();
        return ret;
    }

    @Override
    public String getEntityName()
    {
        return entityName;
    }

    @Override
    public void setEntityName(String entityName)
    {
        this.entityName = entityName;
    }
}
