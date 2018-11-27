package com.hiber.Generator;

import com.hiber.DBClass.Employee;

public class EmployeeGenerator extends SkeletonGenerator
{
    public static Employee generateEmployee()
    {
        return new Employee(generator.generateString(), generator.generateString(), null);
    }
}
