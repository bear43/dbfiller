package com.hiber.dbclasses;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Firstname")
    private String firstname;

    @Column(name = "Secondname")
    private String secondname;

    @Column(name = "DepartmentID")
    private Integer departmentID;

    public Employee(String firstname, String secondname, Department department)
    {
        this(firstname, secondname, department == null ? null : department.getId());
    }

    public Employee(String firstname, String secondname)
    {
        this(firstname, secondname, (Department)null);
    }

    public Employee(String firstname, String secondname, Integer departmentID)
    {
        this.firstname = firstname;
        this.secondname = secondname;
        this.departmentID = departmentID;
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

    public Integer getDepartmentID()
    {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID)
    {
        this.departmentID = departmentID;
    }

    @Override
    public String toString()
    {
        return String.format("Employee ID: %d\nFirstname: %s\nSecondname: %s\nDepartment ID: %d",
                id, firstname, secondname, departmentID);
    }
}
