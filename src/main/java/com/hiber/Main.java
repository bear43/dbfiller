package com.hiber;

import com.hiber.DAO.DAO;
import com.hiber.DAO.DAOImpl;
import com.hiber.DAO.Finder.DepartmentFinderImpl;
import com.hiber.DAO.Finder.Finder;
import com.hiber.DAO.Finder.FinderImpl;
import com.hiber.DBClass.*;
import com.hiber.Generator.FullUnitGenerator;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main
{

    public static void main(String[] args) throws Exception
    {
        try
        {
            Unit u;
            FullUnitGenerator generator = new FullUnitGenerator();
            generator.generateTypes(30);
            new Thread(() ->
            {
                try
                {
                    for (SpentType s : generator.getTypes())
                        s.save();
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }).run();
            for(int i = 0; i < 30; i++)
            {
                u = generator.generate(30, 1, 30);
                final List<Limit> limits = Arrays.asList(u.getLimits());
                new Thread(() ->{
                    try
                    {
                        for (Limit l : limits)
                            l.save();
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }).run();
                u.getDepartment().save();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
