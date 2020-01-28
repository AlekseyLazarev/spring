package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Class CreateStudentDemo
 * <p>
 * Date: 21.01.2020
 *
 * @author a.lazarev
 */
public class UpdateStudentDemo {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            int studentId = 1;

            System.out.println("Getting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Updating student. . .");
            myStudent.setFirstName("Scooby");

            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Update email for all students");

            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done !");

        }
    }
}
