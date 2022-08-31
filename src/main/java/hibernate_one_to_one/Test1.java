package hibernate_one_to_one;


import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(hibernate_one_to_one.entity.Employee.class).
                addAnnotatedClass(hibernate_one_to_one.entity.Detail.class).
                buildSessionFactory();
        Session session = null;
        try {
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Zaur", "Tregulov", "IT", 500);
//            Detail detail = new Detail("Baku", "123456", "zaurtreg.@mail.ru");
//            employee.setEmpDetail(detail);
//
//            session.beginTransaction();
//
//            session.save(employee);
//
//            session.getTransaction().commit();
//            System.out.println("DONE");


//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Oleg", "Smirnov", "Sales", 500);
//            Detail detail = new Detail("Moscow", "987654", "olegs.@gmail.ru");
//            employee.setEmpDetail(detail);
//
//            session.beginTransaction();
//
//            session.save(employee);
//
//            session.getTransaction().commit();
//            System.out.println("DONE");




//            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 10);
//            System.out.println(emp);
//            System.out.println(emp.getEmpDetail());
//
//
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee emp = session.get(Employee.class, 2);
            session.delete(emp);

            session.getTransaction().commit();
            System.out.println("DONE");
        }
        finally{
            session.close();
            factory.close();
        }

    }
}
