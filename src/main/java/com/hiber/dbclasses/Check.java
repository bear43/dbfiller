package com.hiber.dbclasses;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "T_check")
public class Check
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "EmployeeID")
    private Integer employeeID;

    @Column(name = "Date")
    private Date date;

    @Column(name = "SpentTypeID")
    private Integer spentTypeID;

    @Column(name = "Total")
    private long total;

    public Check(Employee employee, Date date, SpentType spentType, long total)
    {
        this(employee == null ? null : employee.getId(), date, spentType == null ? null : spentType.getId(), total);
    }

    public Check(Integer employeeID, Date date, Integer spentTypeID, long total)
    {
        this.employeeID = employeeID;
        this.date = date;
        this.spentTypeID = spentTypeID;
        this.total = total;
    }

    public Check()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Integer getEmployeeID()
    {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID)
    {
        this.employeeID = employeeID;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Integer getSpentTypeID()
    {
        return spentTypeID;
    }

    public void setSpentTypeID(Integer spentTypeID)
    {
        this.spentTypeID = spentTypeID;
    }

    public long getTotal()
    {
        return total;
    }

    public void setTotal(long total)
    {
        this.total = total;
    }

    @Override
    public String toString()
    {
        return String.format("Check ID: %d\nEmployee ID: %d\nDate: %s\nSpentTypeID: %d\nTotal: %d",
                id, employeeID, date, spentTypeID, total);
    }
}
