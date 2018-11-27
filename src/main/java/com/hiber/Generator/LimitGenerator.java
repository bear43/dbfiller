package com.hiber.Generator;

import com.hiber.DBClass.Limit;

import java.sql.Date;

public class LimitGenerator extends SkeletonGenerator
{
    public static Limit generateLimit()
    {
        Date startDate = generator.generateDate();
        int plusDays = generator.generateInt(360);
        return new Limit(generator.generateLong(), startDate,
                Date.valueOf(startDate.toLocalDate().plusDays(plusDays)));
    }

    public static Limit generateLimit(Date startDate)
    {
        int plusDays = generator.generateInt(360);
        return new Limit(generator.generateLong(), startDate,
                Date.valueOf(startDate.toLocalDate().plusDays(plusDays)));
    }
}
