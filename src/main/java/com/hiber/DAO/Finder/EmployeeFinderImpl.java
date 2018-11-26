package com.hiber.DAO.Finder;

import com.hiber.DBClass.Employee;

public class EmployeeFinderImpl extends FinderImpl
{
    public EmployeeFinderImpl()
    {
        super(Employee.class.getSimpleName());
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
