package com.example.hiber;


import com.example.hiber.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();

            session.beginTransaction();

            List<Employee> employeeList = session.createQuery("from Employee "+
                    "where salary > 500 " + "and department = 'HR'").getResultList();
            for (Employee e : employeeList)
                System.out.println(e);

            session.getTransaction().commit();
            System.out.println("DONE");


        } catch(Exception e)
        {}
        finally{
            factory.close();
        }

    }
}
