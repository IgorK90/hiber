package com.example.hiber;


import com.example.hiber.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();

            session.beginTransaction();

            session.createQuery("update Employee set salary=1000 "+
                    "where name = 'Alex'").executeUpdate();

//            Employee emp = session.get(Employee.class,1);
//            emp.setSalary(1500);


            session.getTransaction().commit();
            System.out.println("DONE");


        } catch(Exception e)
        {}
        finally{
            factory.close();
        }

    }
}
