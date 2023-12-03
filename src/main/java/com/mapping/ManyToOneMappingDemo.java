package com.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ManyToOneMappingDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        OneToManyMappingQuestion oneToManyMappingQuestion = new OneToManyMappingQuestion();
        oneToManyMappingQuestion.setQuestionId(1);
        oneToManyMappingQuestion.setQuestion("Why java is so famous?");

        ManyToOneAnswer manyToOneAnswer = new ManyToOneAnswer();
        manyToOneAnswer.setAnswerId(2);
        manyToOneAnswer.setAnswer("This is the one of the best backend language");
        manyToOneAnswer.setQuestion(oneToManyMappingQuestion);

        ManyToOneAnswer manyToOneAnswer1 = new ManyToOneAnswer();
        manyToOneAnswer1.setAnswerId(3);
        manyToOneAnswer1.setAnswer("\nJava is multithreading language");
        manyToOneAnswer1.setQuestion(oneToManyMappingQuestion);


        ManyToOneAnswer manyToOneAnswer2 = new ManyToOneAnswer();
        manyToOneAnswer2.setAnswerId(1);
        manyToOneAnswer2.setAnswer("\n Java is majorly used in MNC company");
        manyToOneAnswer2.setQuestion(oneToManyMappingQuestion);

        List<ManyToOneAnswer> list = new ArrayList<>();

        list.add(manyToOneAnswer1);
        list.add(manyToOneAnswer);
        list.add(manyToOneAnswer2);

        oneToManyMappingQuestion.setAnswers(list);

        session.save(manyToOneAnswer1);
        session.save(manyToOneAnswer);
        session.save(manyToOneAnswer2);
        session.save(oneToManyMappingQuestion);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
