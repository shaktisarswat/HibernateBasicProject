package com.hibernate.mapping.onetoonemapping;

import com.hibernate.mapping.onetoonemapping.Answer;
import com.hibernate.mapping.onetoonemapping.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        // creating Question object

        Answer answer = new Answer(1, "Java is a programming language");
        Question question = new Question(1, "What is the Java", answer);

        session.save(answer);
        session.save(question);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
