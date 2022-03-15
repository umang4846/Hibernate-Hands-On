package com.hibernate.handson.one_to_many;

import com.hibernate.handson.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class OneToManyDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();

        QuestionOtoM question1 = new QuestionOtoM();
        question1.setQuestion("What is Java?");

        QuestionOtoM question2 = new QuestionOtoM();
        question2.setQuestion("What is Collection Framework?");

        AnswerOtoM answer1 = new AnswerOtoM();
        answer1.setAnswer("Java is Programming language");

        AnswerOtoM answer2 = new AnswerOtoM();
        answer2.setAnswer("We can create software in java");

        List<AnswerOtoM> answers = new ArrayList<>();
        answers.add(answer1);
        answers.add(answer2);

        question1.setAnswers(answers);
        answer2.setQuestion(question1);

        AnswerOtoM answer3 = new AnswerOtoM();
        answer3.setAnswer("Collection of Object");

        AnswerOtoM answer4 = new AnswerOtoM();
        answer4.setAnswer("Collcetion hierarcy has many class");

        List<AnswerOtoM> answers1 = new ArrayList<>();
        answers1.add(answer3);
        answers1.add(answer4);

        question2.setAnswers(answers1);
        answer3.setQuestion(question2);

        Transaction transaction = session.beginTransaction();
        session.save(question1);
        session.save(question2);
        session.save(answer1);
        session.save(answer2);
        session.save(answer3);
        session.save(answer4);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
