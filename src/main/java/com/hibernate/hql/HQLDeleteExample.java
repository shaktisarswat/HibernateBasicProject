package com.hibernate.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLDeleteExample {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        String query = "delete from Student where course=:c";
        int deteletdRow = session.createQuery(query).setParameter("c", "Java").executeUpdate();

        System.out.println(deteletdRow);
        session.close();
        sessionFactory.close();
    }
}
