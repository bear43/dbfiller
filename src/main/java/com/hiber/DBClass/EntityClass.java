package com.hiber.DBClass;

import com.hiber.DAO.DAO;
import com.hiber.DAO.DAOImpl;

import java.io.IOException;
import java.util.Collection;

public class EntityClass
{
    private final static DAO saver = new DAOImpl();

    public void save() throws IOException
    {
        saver.create(this);
        saver.close();
    }

    public void load() throws IOException
    {
        saver.read(this);
        saver.close();
    }

    protected void saveCollection(Collection<? extends EntityClass> collection) throws IOException
    {
        for(EntityClass object : collection)
            if(object != null) object.save();
    }
}
