package com.example.hiber;


import com.example.hiber.entity.Employee;
import com.example.hiber.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Long.parseLong;

public class TestFileReader {
    public static void main(String[] args) {
        BufferedReader reader;
        List<Person> personList= new LinkedList<Person>();
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\Work\\IdeaProjects\\hiber\\hiber\\src\\main\\java\\com\\example\\hiber\\PersonalData.txt"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                String[] data = line.split("/");
                Person person = new Person( data[0], data[1],parseLong(data[2]));
                personList.add(person);
                line = reader.readLine();
            }
            for (Person p: personList)
                System.out.println(p);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class).buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();

            session.beginTransaction();
            for (Person p:personList)
                session.save(p);

            session.getTransaction().commit();
            System.out.println("DONE");

        }
        finally{
            factory.close();
        }

    }
}
