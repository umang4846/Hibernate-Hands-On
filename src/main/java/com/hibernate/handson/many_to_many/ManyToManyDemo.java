package com.hibernate.handson.many_to_many;

import com.hibernate.handson.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManyToManyDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();

        Employee employee1 = new Employee();
        employee1.setName("Umang");

        Employee employee2 = new Employee();
        employee2.setName("Ram");

        Project project1 = new Project();
        project1.setProjectName("Chatbot");

        Project project2 = new Project();
        project2.setProjectName("Library Management");

        employee2.setProjects(Collections.singletonList(project1));

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        List<Project> projects = new ArrayList<>();
        projects.add(project1);
        projects.add(project2);

        employee1.setProjects(projects);
        project1.setEmployees(employees);

        Transaction transaction = session.beginTransaction();
        session.save(employee1);
        session.save(employee2);
        session.save(project1);
        session.save(project2);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
