package com.hibernate.handson;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Student student = new Student();
        student.setId(1);
        student.setName("umang");
        student.setCity("ahmedabad");
        System.out.println(student);

        Address address = new Address();
        address.setAddressId(121);
        address.setStreet("this is street");
        address.setCity("this is city");
        address.setX(1.00);
        address.setOpen(true);
        address.setAddedDate(new Date());

        FileInputStream fileInputStream = new FileInputStream("src/main/resources/pic.jpg");
        byte[] arr = new byte[fileInputStream.available()];
        fileInputStream.read(arr);
        address.setImage(arr);

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();
        session.save(student);
        session.save(address);
        transaction.commit();

        session.close();

        factory.close();
    }
}
