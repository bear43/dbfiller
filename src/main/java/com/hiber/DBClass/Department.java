package com.hiber.DBClass;


import javax.persistence.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    private List<Employee> employees = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private List<Collision> collisions = new ArrayList<>();

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

    public List<Employee> getEmployees()
    {
        return employees;
    }

    public void setEmployees(List<Employee> employees)
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
        super.saveCollection(employees);
        super.saveCollection(collisions);
    }

    public void addLimit(Limit limit, SpentType spentType)
    {
        collisions.add(new Collision(this, limit, spentType));
    }

    public void removeLimit(Limit limit, boolean wholeCollision)
    {
        Collision col;
        for(int i = 0; i < collisions.size(); i++)
        {
            col = collisions.get(i);
            if (col.equalsByDepartament(this) && col.equalsByLimit(limit))
            {
                collisions.remove(i);
                if(!wholeCollision)
                    return;
            }
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof Department && ((Department) obj).id == id;
    }

    @Override
    public int hashCode()
    {
        return id^title.hashCode();
    }
}
