package main;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory createSessionFactory() {
        Configuration cfg = new Configuration();

        cfg.addAnnotatedClass(main.Employee.class).configure();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();

        sessionFactory = cfg.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }

    public static void close() {
        sessionFactory.close();
    }
}
