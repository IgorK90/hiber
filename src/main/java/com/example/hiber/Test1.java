package com.example.hiber;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(hiber.entity.Employee.class).buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            hiber.entity.Employee emp = new hiber.entity.Employee("Igor", "Kiyashko", "IT", 500);
            session.beginTransaction();

            session.save(emp);
            session.getTransaction().commit();

        } catch(Exception e)
        {}
        finally{
            factory.close();
        }

    }
}
