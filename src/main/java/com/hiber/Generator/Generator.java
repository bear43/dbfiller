package com.hiber.Generator;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;

public class Generator
{
    private final int MAX_STRLEN;

    private final int MIN_STRLEN;

    private final Date START_DATE;

    private final Date END_DATE;

    private Random r = new Random();

    public Generator()
    {
        this(20, 4);
    }

    public Generator(int max_strlen, int min_strlen)
    {
        this(max_strlen, min_strlen,
                Date.valueOf(LocalDate.of(2010, 1, 1)),
                Date.valueOf(LocalDate.of(2020, 1, 1)));
    }

    public Generator(int max_strlen, int min_strlen, Date start_date, Date end_date)
    {
        this.MAX_STRLEN = max_strlen;
        this.MIN_STRLEN = min_strlen;
        this.START_DATE = start_date;
        this.END_DATE = end_date;
    }

    public String generateString()
    {
        int charSize = r.nextInt(MAX_STRLEN+1);
        charSize = charSize < MIN_STRLEN ? MIN_STRLEN : charSize;
        char[] charArray = new char[charSize];
        for(int i = 0; i < charSize; i++)
            charArray[i] = (char)r.nextInt(128);
        return new String(charArray);
    }

    public Date generateDate(Date min, Date max)
    {
        long minimum = min.getTime();
        long maximum = max.getTime();
        long generated;
        do generated = minimum + Math.abs(r.nextInt(Integer.MAX_VALUE));
        while(generated < minimum || generated > maximum);
        return new Date(generated);
    }

    public int generateInt(int max)
    {
        return r.nextInt(max);
    }

    public Date generateDate()
    {
        return generateDate(START_DATE, END_DATE);
    }

    public long generateLong()
    {
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
