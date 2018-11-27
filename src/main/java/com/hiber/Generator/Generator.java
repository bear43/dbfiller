package com.hiber.Generator;

import java.sql.Date;
import java.util.Random;

public class Generator
{
    private final int MAX_STRLEN;

    private final int MIN_STRLEN;

    public Generator()
    {
        this(20, 4);
    }

    public Generator(int max_strlen, int min_strlen)
    {
        this.MAX_STRLEN = max_strlen;
        this.MIN_STRLEN = min_strlen;
    }

    public String generateString()
    {
        Random r = new Random();
        int charSize = r.nextInt(MAX_STRLEN+1);
        charSize = charSize < MIN_STRLEN ? MIN_STRLEN : charSize;
        char[] charArray = new char[charSize];
        for(int i = 0; i < charSize; i++)
            charArray[i] = (char)r.nextInt(128);
        return new String(charArray);
    }

    public Date generateDate(Date min, Date max)
    {
        Random r = new Random();
        long minimum = min.getTime();
        long maximum = max.getTime();
        long generated;
        do generated = Math.abs(r.nextLong());
        while(generated < minimum && generated > maximum);
        return new Date(generated);
    }

    public Date generateDate()
    {
        return generateDate(new Date(0), new Date(Long.MAX_VALUE));
    }

    public long generateLong()
    {
        Random r = new Random();
        return Math.abs(r.nextLong());
    }

    public int getMAX_STRLEN()
    {
        return MAX_STRLEN;
    }

    public int getMIN_STRLEN()
    {
        return MIN_STRLEN;
    }
}
