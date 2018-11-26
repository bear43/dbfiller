package com.hiber;

import com.hiber.DAO.DAO;
import com.hiber.DAO.DAOImpl;
import com.hiber.DAO.Finder.DepartmentFinderImpl;
import com.hiber.DAO.Finder.Finder;
import com.hiber.DAO.Finder.FinderImpl;
import com.hiber.DBClass.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main
{
    private static final int REPEAT_COUNT = 5;

    private static final String[] depTitles = new String[]
    {
            "Money",
            "Security",
            "Managment"
    };

    private static final SpentType[] types = new SpentType[]
            {
                    new SpentType("Office needs", "Some paper, pencil, pen, etc"),
                    new SpentType("Flex", "Relax items for soul resting")
            };

    private static final Limit[] limits = new Limit[]
            {
                    new Limit(10800, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusDays(30))),
                    new Limit(12100, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusDays(30)))
            };

    public static void main(String[] args) throws Exception
    {
        Finder finder;
        Department[] deps = new Department[]{
                new Department("Security"),
                new Department("Managment"),
                new Department("Service")
        };

        Employee[] emps = new Employee[]{
                new Employee("John", "Smith", deps[0]),
                new Employee("Flex", "Bold", deps[0])
        };
        Employee[] emps2 = new Employee[]{
                new Employee("Care", "Ware", deps[1]),
                new Employee("Carl", "Johnson", deps[1])
        };
        deps[0].getEmployees().addAll(Arrays.asList(emps));
        deps[1].getEmployees().addAll(Arrays.asList(emps2));
        //deps[2].getEmployees().addAll(Arrays.asList(emps));
        List res;
        try
        {
            deps[0].save();
            deps[1].save();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
