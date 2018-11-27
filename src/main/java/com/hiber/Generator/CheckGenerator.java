package com.hiber.Generator;

import com.hiber.DBClass.Check;

public class CheckGenerator
{
    public static Check generateCheck()
    {
        Generator generator = new Generator();
        return new Check(null, generator.generateDate(), null, generator.generateLong());
    }
}
