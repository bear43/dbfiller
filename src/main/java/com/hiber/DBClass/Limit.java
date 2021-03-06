package com.hiber.DBClass;


import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "T_Limit")
public class Limit extends EntityClass
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private long total;

    private Date startDate;

    private Date endDate;

    @OneToMany(mappedBy = "limit")
    private Set<Collision> collisions;

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

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof Limit && ((Limit) obj).id == id;
    }

    @Override
    public int hashCode()
    {
        return id^startDate.hashCode()^endDate.hashCode()^(int)total;
    }
}
