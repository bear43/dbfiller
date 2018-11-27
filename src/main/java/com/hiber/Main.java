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
import java.util.Random;

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

    private static Collision[] colisik;

    public static void main(String[] args) throws Exception
    {
        Random r = new Random();
        Finder finder;
        Department[] deps = new Department[]{
                new Department("Security"),
                new Department("Managment"),
                new Department("Service")
        };

        for(SpentType type : types)
            type.save();
        for(Limit l : limits)
            l.save();

        colisik = new Collision[]
                {
                        new Collision(deps[0], limits[0], types[0]),
                        new Collision(deps[0], limits[1], types[1]),
                        new Collision(deps[1], limits[0], types[0]),
                        new Collision(deps[1], limits[1], types[1]),
                        new Collision(deps[2], limits[0], types[0]),
                        new Collision(deps[2], limits[1], types[1]),
                };

        Employee[] emps = new Employee[]{
                new Employee("John", "Smith", deps[0]),
                new Employee("Flex", "Bold", deps[0]),
                new Employee("Dart", "Baron", deps[0]),
                new Employee("Fenrir", "Paren", deps[0]),
                new Employee("Decl", "Km", deps[0]),
                new Employee("Erit", "Pen", deps[0]),
                new Employee("James", "Hetfild", deps[0]),
                new Employee("Bill", "Geits", deps[0]),
                new Employee("Mac", "Intosh", deps[0]),
                new Employee("Lebron", "James", deps[0]),
                new Employee("Vladimir", "Putin", deps[0]),
                new Employee("James", "Reborn", deps[0]),
                new Employee("Kerabon", "Tarabon", deps[0]),
                new Employee("Petan", "Matan", deps[0]),
                new Employee("Kinder", "Finder", deps[0]),
                new Employee("Lek", "Pek", deps[0]),
                new Employee("Zhivem", "Norem", deps[0]),
                new Employee("Ketan", "Matan", deps[0]),
                new Employee("LOOOL", "POOOL", deps[0]),
                new Employee("Dart", "Weider", deps[0]),
                new Employee("Johny", "Sins", deps[0]),
                new Employee("Sin", "Cos", deps[0]),
                new Employee("Plex", "Fold", deps[0]),
                new Employee("Love", "Tits", deps[0]),
                new Employee("I", "Soso", deps[0]),
                new Employee("Man", "Can", deps[0]),
                new Employee("Do", "This", deps[0]),
                new Employee("Shit", "If", deps[0]),
                new Employee("He", "Is", deps[0]),
                new Employee("Crazy", "Bitch", deps[0])
        };
        Employee[] emps2 = new Employee[]{
                new Employee("Care", "Ware", deps[1]),
                new Employee("Carl", "Johnson", deps[1])
        };
        for(Employee e : emps)
            e.getCheckSet().add(new Check(e, new Date(r.nextInt(Integer.MAX_VALUE)), types[r.nextInt(2)],
                    r.nextInt(100000)));
        deps[0].getEmployees().addAll(Arrays.asList(emps));
        deps[1].getEmployees().addAll(Arrays.asList(emps2));
        //deps[2].getEmployees().addAll(Arrays.asList(emps));
        List res;
        try
        {
            deps[0].save();
            deps[1].save();
            deps[2].save();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
