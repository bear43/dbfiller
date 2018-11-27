package com.hiber.DBClass;

import javax.persistence.*;
import java.io.IOException;
import java.sql.Date;

@Entity
@Table(name = "T_Check")
public class Check extends EntityClass
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date date;

    private long total;

    @ManyToOne
    private SpentType spentType;

    @ManyToOne
    private Employee employee;

    public Check(Employee employee, Date date, SpentType spentType, long total)
    {
        this.employee = employee;
        this.date = date;
        this.spentType = spentType;
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

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public long getTotal()
    {
        return total;
    }

    public void setTotal(long total)
    {
        this.total = total;
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }



    @Override
    public String toString()
    {
        return String.format("Check ID: %d\n%s\nDate: %s\n%s\nTotal: %d",
                id, employee.toString(), date, spentType.toString(), total);
    }
}
