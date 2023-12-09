package com.hibernate.caching.secondlevelcaching;

import com.hibernate.basicentity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Second level caching is implemented on Session Factory, and it is implemented manually by developer
 */
public class SecondLevelCache {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        // fetching object from DB

        Student student = session.get(Student.class, 2);
        System.out.println(student);
        session.close();

        Session session1 = sessionFactory.openSession();
        System.out.println("Fetching same object by executing query");
        Student student1 = session1.get(Student.class, 2);
        System.out.println(student1);
        session1.close();
        sessionFactory.close();
    }
}
