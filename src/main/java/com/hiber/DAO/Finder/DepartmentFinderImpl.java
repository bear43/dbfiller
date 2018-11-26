package com.hiber.DAO.Finder;

import com.hiber.DBClass.Department;

public class DepartmentFinderImpl extends FinderImpl
{
    public DepartmentFinderImpl()
    {
        super(Department.class.getSimpleName());
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
