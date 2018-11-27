package com.hiber.Generator;

import com.hiber.DBClass.Department;

public class DepartmentGenerator extends SkeletonGenerator
{
    public static Department generateDepartment()
    {
        return new Department(generator.generateString());
    }
}
