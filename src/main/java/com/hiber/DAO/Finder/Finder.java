package com.hiber.DAO.Finder;

import com.hiber.DAO.DAO;

import java.util.List;

public interface Finder extends DAO
{
    Object findByID(long id);

    List findAll();

    void setEntityName(String entityName);

    String getEntityName();
}
