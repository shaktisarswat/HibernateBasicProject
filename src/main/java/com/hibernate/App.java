package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("hello");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        System.out.println(factory);

        Student student = new Student(2, "Sahil", "Churu");
        System.out.println(student);
        Address address = new Address();
        address.setStreet("street1");
        address.setCity("Jaipur");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(10.0);
        System.out.println(address);

        // Inserting data
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\shakti_sarswat\\Desktop\\JAVA\\HibernateBasicProject\\src\\main\\resources\\window.jpg");
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        address.setImage(bytes);
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(student);
        session.save(address);
        session.getTransaction().commit();

        // Getting Object from database

        Student student1 = (Student) session.get(Student.class, 2);
        Address address1 = (Address) session.get(Address.class, 1);

        System.out.println(student1);
        System.out.println(address1);


        session.close();
    }
}
