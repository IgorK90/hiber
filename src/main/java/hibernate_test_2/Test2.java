package hibernate_test_2;


import hibernate_test_2.entity.Detail;
import hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).
                addAnnotatedClass(Detail.class).
                buildSessionFactory();
        Session session = null;
        try {
//            session = factory.getCurrentSession();
//            Employee emp = new Employee("Nikolay","Ivanov", "HR", 860);
//            Detail detail = new Detail("NY","+7787882938","niko@gmail.com");
//            emp.setEmpDetail(detail);
//            detail.setEmployee(emp);
//            session.beginTransaction();
//            session.save(detail);
//
//            session.getTransaction().commit();
//            System.out.println("DONE");

            session = factory.getCurrentSession();

            session.beginTransaction();
            Detail detail = session.get(Detail.class, 1);
            detail.getEmployee().setEmpDetail(null);

            session.delete(detail);
            session.getTransaction().commit();
            System.out.println("DONE");

        }
        finally{
            session.close();
            factory.close();
        }

    }
}
