package com.hiber.DBClass;


import javax.persistence.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Department extends EntityClass
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String title;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees = new HashSet<>();

    @OneToMany(mappedBy = "department")
    private Set<Collision> collisions = new HashSet<>();

    public Department()
    {

    }

    public Department(String title)
    {
        this.title = title;
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

    public Set<Employee> getEmployees()
    {
        return employees;
    }

    public void setEmployees(Set<Employee> employees)
    {
        this.employees = employees;
    }

    @Override
    public String toString()
    {
        return String.format("Department ID: %d\nTitle: %s\nEmployeeCount: %d", id, title, employees.size());
    }

    @Override
    public void save() throws IOException
    {
        super.save();
        for(Employee e : employees)
            e.save();
    }
}
