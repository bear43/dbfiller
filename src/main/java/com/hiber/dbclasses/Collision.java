package com.hiber.dbclasses;

import javax.persistence.*;

@Entity
@Table(name = "collision")
public class Collision
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "DepartmentID")
    private Integer departmentID;

    @Column(name = "LimitID")
    private Integer limitID;

    @Column(name = "SpentTypeID")
    private Integer spentTypeID;

    public Collision()
    {

    }

    public Collision(Integer departmentID, Integer limitID, Integer spentTypeID)
    {
        this.departmentID = departmentID;
        this.limitID = limitID;
        this.spentTypeID = spentTypeID;
    }

    public Collision(Department department, Limit limit, SpentType spentType)
    {
        this(department == null ? null : department.getId(), limit == null ? null : limit.getId(), spentType == null ? null : spentType.getId());
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Integer getDepartmentID()
    {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID)
    {
        this.departmentID = departmentID;
    }

    public Integer getLimitID()
    {
        return limitID;
    }

    public void setLimitID(Integer limitID)
    {
        this.limitID = limitID;
    }

    public Integer getSpentTypeID()
    {
        return spentTypeID;
    }

    public void setSpentTypeID(Integer spentTypeID)
    {
        this.spentTypeID = spentTypeID;
    }

    @Override
    public String toString()
    {
        return String.format("Collision ID: %d\nDepartment ID: %d\nLimit ID: %d\nSpentTypeID: %d",
                id, departmentID, limitID, spentTypeID);
    }
}
