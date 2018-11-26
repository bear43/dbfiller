package com.hiber.DAO.Finder;

import com.hiber.DBClass.Check;

public class CheckFinderImpl extends FinderImpl
{
    public CheckFinderImpl()
    {
        super(Check.class.getSimpleName());
    }

    @Deprecated
    @Override
    public void setEntityName(String entityName)
    {
    }

    @Override
    public String getEntityName()
    {
        return super.getEntityName();
    }
}
