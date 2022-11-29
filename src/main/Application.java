package main;

import gui.OperationSelectionMenu;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        new Application();
        new OperationSelectionMenu();
    }
    public List<Employee> getAllEmployees() {
        Transaction transaction = null;
        List<Employee> list = null;

        try (Session session = HibernateUtil.createSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = "from Employee as e";
            list = session.createQuery(hql, Employee.class).list();
            transaction.commit();
            session.close();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public List<Employee> searchEmployees(String lastName) throws ConcurrentModificationException {
        List<Employee> list = new ArrayList<>();
        Transaction transaction;
        Session session = HibernateUtil.createSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "from Employee as e where e.last_name = ?0";
            list = session.createQuery(hql, Employee.class).setParameter(0, lastName).getResultList();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return list;

    }


    public void addEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.createSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Employee tmpEmployee = new Employee(employee.getFirstName(), employee.getLastName(), employee.getYears(), employee.getAddress(), employee.getSalary());
            session.persist(tmpEmployee);

            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Employee getEmployeeByID(int id) {
        Transaction transaction = null;
        Employee employee = null;
        try (Session session = HibernateUtil.createSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            employee = session.get(Employee.class, id);
            System.out.println("Debugging getEmployeeID method: " + employee.toString());

            transaction.commit();
            session.close();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return employee;
    }


    public void updateEmployee(int employeeId, String firstName, String lastName, int years, String address, int salary) {
        Transaction transaction = null;
        Employee employee;
        try (Session session = HibernateUtil.createSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            employee = session.get(Employee.class, employeeId);

            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setYears(years);
            employee.setAddress(address);
            employee.setSalary(salary);

            session.update(employee);

            transaction.commit();
            session.close();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        Transaction transaction = null;
        Employee employee;
        try (Session session = HibernateUtil.createSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            employee = session.get(Employee.class, id);
            session.delete(employee);
            transaction.commit();
            session.close();

        } catch (HibernateException e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}