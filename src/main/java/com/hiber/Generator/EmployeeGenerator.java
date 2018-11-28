package com.hiber.Generator;

import com.hiber.DBClass.Employee;
import com.hiber.Util.Picker;

import java.util.Arrays;

public class EmployeeGenerator extends SkeletonGenerator
{
    private static final String[] firstnamePull = new String[]
            {
                    "John",
                    "Lemmy",
                    "Ivan",
                    "Boris",
                    "Sam",
                    "Alex",
                    "James",
                    "Victor",
                    "King",
                    "Dick",
                    "Frank",
                    "Carl",
                    "Kirill",
                    "Cesar",
                    "David",
                    "Martin",
                    "Bill",
                    "Steve",
                    "Kirk",
                    "Axel"
            };

    private static final String[] secondnamePull = new String[]
            {
                    "Jefferson",
                    "Mihalkov",
                    "Kilmister",
                    "Geits",
                    "Jobs",
                    "Lopez",
                    "Nervanko",
                    "Pozaranko",
                    "Lopuhov",
                    "Kreckoff",
                    "Smirnov",
                    "Sidorov",
                    "Ivanov",
                    "Alexandrov",
                    "Philipov",
                    "Flexov",
                    "Mariachi",
                    "Asakura",
                    "Udzumaki",
                    "Kavasaki",
                    "Mangake",
                    "Polosake",
                    "Sake"
            };

    public static Employee generateEmployee()
    {
        return new Employee(generator.generateString(), generator.generateString(), null);
    }

    public static Employee generateEmployeeEx()
    {
        return new Employee((String)Picker.pickFromCollection(Arrays.asList(firstnamePull)),
                (String)Picker.pickFromCollection(Arrays.asList(secondnamePull)), null);
    }
}
