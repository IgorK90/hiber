package com.example.hiber;


import com.example.hiber.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(com.example.hiber.entity.Employee.class).buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            com.example.hiber.entity.Employee emp = new com.example.hiber.entity.Employee("Oleg",
                    "Sidorov",
                    "HR",
                    800);
            session.beginTransaction();
            session.save(emp);
//            session.getTransaction().commit();

            int myId = emp.getId();
//            session = factory.getCurrentSession();
//            session.beginTransaction();
            Employee employee = session.get( Employee.class, myId);
            session.getTransaction().commit();
            System.out.println(employee );
            System.out.println("DONE");
//            System.out.println(emp);

        } catch(Exception e)
        {}
        finally{
            factory.close();
        }

    }
}
