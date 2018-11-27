package com.hiber.DBClass;

import javax.persistence.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee extends EntityClass
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstname;

    private String secondname;

    @OneToMany(mappedBy = "employee")
    private Set<Check> checkSet = new HashSet<>();

    @ManyToOne
    private Department department;

    public Employee(String firstname, String secondname, Department department, Check check)
    {
        this.firstname = firstname;
        this.secondname = secondname;
        this.department = department;
        this.checkSet.add(check);
    }

    public Employee(String firstname, String secondname, Department department)
    {
        this(firstname, secondname, department, null);
    }

    public Employee()
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

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getSecondname()
    {
        return secondname;
    }

    public void setSecondname(String secondname)
    {
        this.secondname = secondname;
    }

    public Department getDepartment()
    {
        return department;
    }

    public void setDepartment(Department department)
    {
        this.department = department;
    }

    public Set<Check> getCheckSet()
    {
        return checkSet;
    }

    public void setCheckSet(Set<Check> checkSet)
    {
        this.checkSet = checkSet;
    }

    @Override
    public String toString()
    {
        return String.format("Employee ID: %d\nFirstname: %s\nSecondname: %s\n%s",
                id, firstname, secondname, department.toString());
    }

    @Override
    public void save() throws IOException
    {
        super.save();
        super.saveCollection(checkSet);
    }
}
