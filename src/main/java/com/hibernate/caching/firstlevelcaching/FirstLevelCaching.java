package com.hibernate.caching.firstlevelcaching;

import com.hibernate.basicentity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * First level caching is implemented by default by Java, and it is implemented on session object
 */
public class FirstLevelCaching {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        // fetching object from DB

        Student student = session.get(Student.class, 2);
        System.out.println(student);

        System.out.println("Fetching same object by executing query");
        System.out.println("Checking the object is contained inside the session cache or not ? " + session.contains(student));
        Student student1 = session.get(Student.class, 2);
        System.out.println(student1);

        session.close();
        sessionFactory.close();


    }
}
