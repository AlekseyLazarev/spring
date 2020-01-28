package com.luv2code.hibernate.practice;

import com.luv2code.hibernate.practice.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Class Actions
 * <p>
 * Date: 22.01.2020
 *
 * @author a.lazarev
 */
public class Actions {
    private final SessionFactory factory;

    public Actions(SessionFactory factory) {
        this.factory = factory;

    }

    public void saveEmployee(List<Employee> employees) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        System.out.println("Start saving employees . . .");
        for (Employee employee : employees) {
            session.save(employee);
        }
        session.getTransaction().commit();
        System.out.println("Saving complete !");
    }

    public List<Employee> findEmployeeById(int idEmployee) {
        System.out.println("Start find employee by id = " + idEmployee + " employees . . .");
        return getListFromQuery("from Employee e where e.id=:id", "id", idEmployee);
    }

    public List<Employee> findEmployeeByCompanyName(String companyName) {
        System.out.println("Start find employee by company name = " + companyName + " . . .");
        return getListFromQuery("from Employee e where e.company=:company", "company", companyName);
    }

    private List<Employee> getListFromQuery(String query, String paramName, Object paramValue) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Employee> employees = session.createQuery(query).setParameter(paramName, paramValue).list();
        session.getTransaction().commit();
        return employees;
    }

    public Employee deleteEmployeeById(int idEmployee) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        System.out.println("Start deleting employee by id = " + idEmployee + ". . .");
        Employee employee = session.get(Employee.class, idEmployee);
        System.out.println("Deleting employee: " + employee);
        session.delete(employee);
        System.out.println("Deleting complete!");
        session.getTransaction().commit();
        return employee;
    }

    public void deleteAllEmployees() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        System.out.println("Start deleting all employees . . .");
        session.createQuery("delete from Employee").executeUpdate();
        session.getTransaction().commit();
        System.out.println("Deleting all employees complete!");
    }
}
