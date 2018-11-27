package com.hiber.Generator;

import com.hiber.DBClass.Employee;

public class EmployeeGenerator
{
    public static Employee generateEmployee()
    {
        Generator generator = new Generator();
        return new Employee(generator.generateString(), generator.generateString(), null);
    }
}
