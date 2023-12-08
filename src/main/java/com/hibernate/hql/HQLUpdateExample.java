package com.hibernate.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLUpdateExample {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        String query = "update Student  set city='Jaipur' where name='Sandeep'";
        int deteletdRow = session.createQuery(query).executeUpdate();

        System.out.println(deteletdRow);
        session.close();
        sessionFactory.close();
    }
}
