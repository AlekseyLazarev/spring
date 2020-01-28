package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Class CreateStudentDemo
 * <p>
 * Date: 21.01.2020
 *
 * @author a.lazarev
 */
public class QueryStudentDemo {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Students list");
            List<Student> theStudents = session.createQuery("from Student").list();
            displayStudents(theStudents);

            System.out.println("Students who have last name of Doe");
            theStudents = session.createQuery("from Student s where s.lastName='Doe'").list();
            displayStudents(theStudents);

            System.out.println("Students who have last name of Doe or first name of Daffy");
            theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'").list();
            displayStudents(theStudents);

            System.out.println("Students who have email gmail.com");
            theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").list();
            displayStudents(theStudents);

            session.getTransaction().commit();
            System.out.println("Done !");

        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student student : theStudents) {
            System.out.println(student);
        }
    }
}
