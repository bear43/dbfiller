package com.hiber.dbclasses;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_limit")
public class Limit
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Total")
    private long total;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "EndDate")
    private Date endDate;

    public Limit()
    {

    }

    public Limit(long total, Date startDate, Date endDate)
    {
        this.total = total;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public long getTotal()
    {
        return total;
    }

    public void setTotal(long total)
    {
        this.total = total;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    @Override
    public String toString()
    {
        return String.format("Limit ID: %d\nStartDate: %s\nEndDate: %s\nTotal: %d",
                id, startDate.toString(), endDate.toString(), total);
    }
}
