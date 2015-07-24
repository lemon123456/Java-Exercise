package com.tw.core.Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static SessionFactory sessionFactory ;
    static {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }//在其他代码执行之前会先被调用，而且只调用一次（单例模式）
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
