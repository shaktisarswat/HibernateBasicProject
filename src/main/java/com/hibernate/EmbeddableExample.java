package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmbeddableExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Certificate certificate=new Certificate("Java", "2 Months");
        Student student=new Student(3,"Sandeep","kerala", certificate);
        session.save(student);

        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
