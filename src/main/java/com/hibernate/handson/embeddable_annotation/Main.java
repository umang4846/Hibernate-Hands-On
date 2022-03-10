package com.hibernate.handson.embeddable_annotation;

import com.hibernate.handson.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();

        Student student1 = new Student();
        student1.setId(123);
        student1.setName("Umang Patel");
        student1.setCity("Ahmedabad");

        Certificate certificate1 = new Certificate();
        certificate1.setCourse("Java");
        certificate1.setDuration("3 months");
        student1.setCerti(certificate1);

        Student student2 = new Student();
        student2.setId(321);
        student2.setName("Mee ");
        student2.setCity("Banglore");

        Certificate certificate2 = new Certificate();
        certificate2.setCourse("AWS");
        certificate2.setDuration("2 Months");
        student2.setCerti(certificate2);

        Transaction transaction = session.beginTransaction();
        session.save(student1);
        session.save(student2);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
