package com.example.hiber;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(com.example.hiber.entity.Employee.class).buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            com.example.hiber.entity.Employee emp = new com.example.hiber.entity.Employee("Alex", "Smirnov", "HR", 750);
            session.beginTransaction();

            session.save(emp);
            session.getTransaction().commit();
            System.out.println("DONE");

        } catch(Exception e)
        {}
        finally{
            factory.close();
        }

    }
}
