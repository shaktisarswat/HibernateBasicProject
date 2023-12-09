package com.hibernate.cascading;

import com.hibernate.mapping.onetomany.ManyToOneAnswer;
import com.hibernate.mapping.onetomany.OneToManyMappingQuestion;
import com.hibernate.mapping.onetoonemapping.Answer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


// Cascading is used for inserting entity in table associated with main entity with manually inserting associated entity

public class CascadingExample {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        // Creating main entity question

        OneToManyMappingQuestion oneToManyMappingQuestion = new OneToManyMappingQuestion();
        oneToManyMappingQuestion.setQuestionId(3);
        oneToManyMappingQuestion.setQuestion("Why python is so  in?");

        ManyToOneAnswer manyToOneAnswer = new ManyToOneAnswer();
        manyToOneAnswer.setAnswerId(7);
        manyToOneAnswer.setAnswer("This is the one of the best backend language");
        manyToOneAnswer.setQuestion(oneToManyMappingQuestion);

        ManyToOneAnswer manyToOneAnswer1 = new ManyToOneAnswer();
        manyToOneAnswer1.setAnswerId(8);
        manyToOneAnswer1.setAnswer("\nIt contains many in-built librarys");
        manyToOneAnswer1.setQuestion(oneToManyMappingQuestion);


        ManyToOneAnswer manyToOneAnswer2 = new ManyToOneAnswer();
        manyToOneAnswer2.setAnswerId(9);
        manyToOneAnswer2.setAnswer("\nPython is majorly used in Startups company");
        manyToOneAnswer2.setQuestion(oneToManyMappingQuestion);

        List<ManyToOneAnswer> list = new ArrayList<>();

        list.add(manyToOneAnswer1);
        list.add(manyToOneAnswer);
        list.add(manyToOneAnswer2);

        oneToManyMappingQuestion.setAnswers(list);

//
//        session.save(manyToOneAnswer1);
//        session.save(manyToOneAnswer);
//        session.save(manyToOneAnswer2);
        session.save(oneToManyMappingQuestion);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();


    }
}
