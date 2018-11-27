package com.hiber.Generator;

import com.hiber.DBClass.Check;

import java.sql.Date;

public class CheckGenerator extends SkeletonGenerator
{
    private static int MAX_TOTAL = 100000;

    public static Check generateCheck()
    {
        return new Check(null, generator.generateDate(), null, generator.generateInt(MAX_TOTAL));
    }

    public static Check generateCheck(Date min, Date max)
    {
        return new Check(null, generator.generateDate(min, max), null, generator.generateInt(MAX_TOTAL));
    }

    public static int getMaxTotal()
    {
        return MAX_TOTAL;
    }

    public static void setMaxTotal(int maxTotal)
    {
        MAX_TOTAL = maxTotal;
    }
}
