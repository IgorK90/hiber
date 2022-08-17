package com.example.hiber;


import com.example.hiber.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();

            session.beginTransaction();

//            Employee emp = session.get(Employee.class,1);
//            session.delete(emp);

            session.createQuery("delete Employee where name='Alex'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("DONE");


        } catch(Exception e)
        {}
        finally{
            factory.close();
        }

    }
}
