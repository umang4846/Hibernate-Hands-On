package com.hibernate.handson;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Student student = session.load(Student.class,1); //throw org.hibernate.ObjectNotFoundException
        System.out.println(student);

      //  Student student1 = session.load(Student.class,5); //throw org.hibernate.ObjectNotFoundException
       // System.out.println(student1);

        Address address = session.get(Address.class,1);
       // System.out.println(address);

        session.close();
        factory.close();
    }

}
