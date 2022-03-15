package com.hibernate.handson.one_to_one;

import com.hibernate.handson.embeddable_annotation.Certificate;
import com.hibernate.handson.embeddable_annotation.Student;
import com.hibernate.handson.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OneToOneDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();

        Question question1 = new Question();
        question1.setQuestion("What is Java?");

        Question question2 = new Question();
        question2.setQuestion("What is Collection Framework?");

        Answer answer1 = new Answer();
        answer1.setAnswer("Java is Programming language");
        question1.setAnswer(answer1);
        answer1.setQuestion(question1);

        Answer answer2 = new Answer();
        answer2.setAnswer("Collection of Object");
        question2.setAnswer(answer2);
        answer2.setQuestion(question2);

        Transaction transaction = session.beginTransaction();
        session.save(question1);
        session.save(question2);
        session.save(answer1);
        session.save(answer2);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
