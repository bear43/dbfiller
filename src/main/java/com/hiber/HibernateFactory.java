package com.hiber;

import com.hiber.dbclasses.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateFactory
{
    private static SessionFactory sessionFactory;

    private HibernateFactory()
    {
    }

    public static SessionFactory createSessionFactory() throws Exception
    {
        if(sessionFactory == null || sessionFactory.isClosed())
        {
            Configuration config = new Configuration().configure("hibernate.xml");
            config.addAnnotatedClass(Department.class);
            config.addAnnotatedClass(Employee.class);
            config.addAnnotatedClass(Check.class);
            config.addAnnotatedClass(Limit.class);
            config.addAnnotatedClass(Collision.class);
            config.addAnnotatedClass(SpentType.class);
            StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder().applySettings(config.getProperties());
            config.buildSessionFactory();
            sessionFactory = config.buildSessionFactory(builder.build());
        }
        return sessionFactory;
    }
}
