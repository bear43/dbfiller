package com.hiber.Generator;

import com.hiber.DBClass.SpentType;

public class SpentTypeGenerator extends SkeletonGenerator
{
    public static SpentType generateSpentType()
    {
        return new SpentType(generator.generateString(), generator.generateString());
    }
}
