package com.hiber.Generator;

import com.hiber.DBClass.Department;
import com.hiber.Util.Picker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepartmentGenerator extends SkeletonGenerator
{
    private static final String[] titles = new String[]
            {
                    "Testing",
                    "Security",
                    "Service",
                    "Maintaining",
                    "Information",
                    "Carantin",
                    "Test",
                    "Buying",
                    "Generation",
                    "Communication",
                    "Creating",
                    "Solutions"
            };

    private static final List<String> titlePull = new ArrayList<String>(Arrays.asList(titles));

    public static void reset()
    {
        titlePull.clear();
        titlePull.addAll(Arrays.asList(titles));
    }

    public static Department generateDepartment()
    {
        return new Department(generator.generateString());
    }

    public static Department generateDepartmentEx()
    {
        String title = (String)Picker.pickFromCollection(titlePull);
        titlePull.remove(title);
        return new Department(title);
    }
}
