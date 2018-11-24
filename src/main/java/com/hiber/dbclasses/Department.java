package com.hiber.dbclasses;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Title")
    private String title;

    @Column(name = "EmployeeCount")
    private int employeeCount;

    public Department()
    {

    }

    public Department(String title, int employeeCount)
    {
        this.title = title;
        this.employeeCount = employeeCount;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getEmployeeCount()
    {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount)
    {
        this.employeeCount = employeeCount;
    }

    @Override
    public String toString()
    {
        return String.format("Department ID: %d\nTitle: %s\nEmployeeCount: %d", id, title, employeeCount);
    }
}
