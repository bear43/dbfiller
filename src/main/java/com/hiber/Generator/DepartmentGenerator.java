package com.hiber.Generator;

import com.hiber.DBClass.Department;

public class DepartmentGenerator
{
    public static Department generateDepartment()
    {
        Generator generator = new Generator();
        return new Department(generator.generateString());
    }
}
