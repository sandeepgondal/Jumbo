package com.sandy.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by gondals on 31/08/16.
 */
public class SessionFactoryCreator {

    public static SessionFactory getSessionFactory() {
        return SessionFactoryHolder.INSTANCE;
    }

    private static class SessionFactoryHolder {
        private static SessionFactory INSTANCE = new Configuration().configure().buildSessionFactory();
    }

}
