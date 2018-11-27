package com.hiber.DBClass;

public class Unit
{
    private Department department;
    private SpentType[] spentTypes;
    private Limit[] limits;

    public Unit(Department department, SpentType[] spentTypes, Limit[] limits)
    {
        this.department = department;
        this.spentTypes = spentTypes;
        this.limits = limits;
    }

    public Department getDepartment()
    {
        return department;
    }

    public void setDepartment(Department department)
    {
        this.department = department;
    }

    public SpentType[] getSpentTypes()
    {
        return spentTypes;
    }

    public void setSpentTypes(SpentType[] spentTypes)
    {
        this.spentTypes = spentTypes;
    }

    public Limit[] getLimits()
    {
        return limits;
    }

    public void setLimits(Limit[] limits)
    {
        this.limits = limits;
    }
}
