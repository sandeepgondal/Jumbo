package com.sandy.hibernate.caching;

import com.sandy.hibernate.SessionFactoryCreator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by gondals on 31/08/16.
 */
public class CachingMainClass {

    public static void main(String[] args) {
        System.out.println("Hello Caching");

        SessionFactory sessionFactory = SessionFactoryCreator.getSessionFactory();

        ToBeCached toBeCached = new ToBeCached();
        toBeCached.setName("Sandeep");

        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        session1.save(toBeCached);
        session1.getTransaction().commit();
        session1.close();

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        ToBeCached toBeCached1 = (ToBeCached) session2.get(ToBeCached.class, toBeCached.getId());
        System.out.println("New value: " + toBeCached1.getName());
        session2.getTransaction().commit();
        session2.close();

        Session session3 = sessionFactory.openSession();
        session3.beginTransaction();
        ToBeCached toBeCached2 = (ToBeCached) session3.get(ToBeCached.class, toBeCached.getId());
        System.out.println("New value: " + toBeCached2.getName());
        session3.getTransaction().commit();
        session3.close();

        Session session4 = sessionFactory.openSession();
        session4.beginTransaction();
        ToBeCached toBeCached3 = (ToBeCached) session4.get(ToBeCached.class, toBeCached.getId());
        System.out.println("New value: " + toBeCached3.getName());
        session4.getTransaction().commit();
        session4.close();

        sessionFactory.close();
    }
}
