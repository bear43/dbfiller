package com.hiber.DAO.Finder;

import com.hiber.DBClass.SpentType;

public class SpentTypeFinderImpl extends FinderImpl
{
    public SpentTypeFinderImpl()
    {
        super(SpentType.class.getSimpleName());
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
