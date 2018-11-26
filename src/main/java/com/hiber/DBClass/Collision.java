package com.hiber.DBClass;

import javax.persistence.*;


@Entity
public class Collision
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Department department;

    @ManyToOne
    private SpentType spentType;

    @ManyToOne
    private Limit limits;

    public Collision()
    {

    }

    public Collision(Department department, Limit limit, SpentType spentType)
    {
        this.department = department;
        this.limits = limit;
        this.spentType = spentType;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return String.format("s\n%s\n%s", department.toString(), spentType.toString(), limits.toString());
    }
}
