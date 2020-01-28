package com.luv2code.hibernate.practice;

import com.luv2code.hibernate.practice.entity.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.LinkedList;
import java.util.List;

/**
 * Class MainApp
 * <p>
 * Date: 22.01.2020
 *
 * @author a.lazarev
 */
public class MainApp {
    private final static String FIRST = "first name ";
    private final static String LAST = "last name ";
    private final static String COMPANY = "company name ";

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            List<Employee> employees = new LinkedList<>();
            int genSize = 10;
            for (int a = 0; a < genSize; a++) {
                employees.add(new Employee(FIRST + a, LAST + a, COMPANY + a));
            }
            Actions acts = new Actions(factory);
            acts.saveEmployee(employees);
            System.out.println(acts.findEmployeeById(genSize / 2));
            System.out.println(acts.findEmployeeByCompanyName(COMPANY + genSize / 2));
            System.out.println(acts.deleteEmployeeById(genSize / 3));
        }
    }
}
