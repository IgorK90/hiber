package hibernate_one_to_many_uni;



import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).
                addAnnotatedClass(Department.class).
                buildSessionFactory();
        Session session = null;
        try {

            session = factory.getCurrentSession();

            Department dep = new Department("HR",500,1500);
            Employee emp1 = new Employee("Oleg", "Ivanov",800);
            Employee emp2 = new Employee("Andrey", "Sidorov",1000);

            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);

            session.beginTransaction();
            session.save(dep);

            session.getTransaction().commit();
            System.out.println("DONE");
//***************************************************************************
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Department dep = session.get(Department.class, 2);
//            System.out.println(dep);
//            System.out.println(dep.getEmps());
//
//            session.getTransaction().commit();
//            System.out.println("DONE");

//***************************************************************************
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Employee emp = session.get(Employee.class, 2);
//            System.out.println(emp);
//            System.out.println(emp.getDepartment());
//
//
//            session.getTransaction().commit();
//            System.out.println("DONE");
//***************************************************************************
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Department dep = session.get(Department.class, 3);
//
//            session.delete(dep);
//            session.getTransaction().commit();
//            System.out.println("DONE");
//***************************************************************************
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Employee emp = session.get(Employee.class, 6);
//            System.out.println(emp);
//            System.out.println(emp.getDepartment());
//
//            session.delete(emp);
//
//            session.getTransaction().commit();
//            System.out.println("DONE");


        }
        finally{
            session.close();
            factory.close();
        }

    }
}
