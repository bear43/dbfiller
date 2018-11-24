package com.hiber;

import com.hiber.dbclasses.*;

import java.sql.Date;
import java.time.LocalDate;
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

    public static void main(String[] args) throws Exception
    {
        DAO dao = new DAOImpl();
        Department d = new Department();
        d.setEmployeeCount(1);
        Employee e = new Employee("kek", "jack");
        Check c = new Check();
        Date date;
        Collision col = new Collision();
        Random r = new Random();
        for(SpentType type : types)
            type.setId(dao.save(type));
        for(Limit limit : limits)
            limit.setId(dao.save(limit));
        for(int i = 0; i < REPEAT_COUNT; i++)
            for(String title : depTitles)
            {
                d.setTitle(title);
                d.setId(dao.save(d));
                e.setDepartmentID(d.getId());
                e.setId(dao.save(e));
                c.setEmployeeID(e.getId());
                c.setSpentTypeID(types[r.nextInt(types.length)].getId());
                c.setTotal(Math.abs(r.nextInt()));
                c.setDate(new Date((long)Math.abs(r.nextInt())));
                c.setId(dao.save(c));
                col.setDepartmentID(d.getId());
                col.setLimitID(limits[r.nextInt(limits.length)].getId());
                col.setSpentTypeID(types[r.nextInt(types.length)].getId());
                col.setId(dao.save(col));
            }
    }
}
