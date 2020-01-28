package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;

/**
 * Class CreateStudentDemo
 * <p>
 * Date: 21.01.2020
 *
 * @author a.lazarev
 */
public class CreateStudentDemo {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            System.out.println("Creating new student object . . .");
            Student tempStudent = new Student("Paul", "Wall", "paul@luv2code.com", DateUtils.parseDate("31/12/1998"));
            session.beginTransaction();
            System.out.println("Saving the student");
            session.save(tempStudent);
            session.getTransaction().commit();
            System.out.println("Done !");
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }
}
