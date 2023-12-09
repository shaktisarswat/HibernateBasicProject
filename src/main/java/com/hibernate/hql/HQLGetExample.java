package com.hibernate.hql;

import com.hibernate.basicentity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLGetExample {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        String query = "from Student";

        Query query1 = session.createQuery(query);

        List<Student> studentList = query1.list();

        for (Student s : studentList) {

            System.out.println(s.getName());
        }

//        query = "from Student where name='Sahil'";
        query = "from Student where name=:x";

        List<Student> studentList1 = session.createQuery(query).setParameter("x","Sahil").list();

        for (Student s : studentList1) {
            System.out.println(s.getId());
        }

//        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
