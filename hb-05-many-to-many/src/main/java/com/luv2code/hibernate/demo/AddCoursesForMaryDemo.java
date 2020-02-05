package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.plaf.IconUIResource;

/**
 * Class CreateDemo
 * <p>
 * Date: 28.01.2020
 *
 * @author a.lazarev
 */
public class AddCoursesForMaryDemo {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            int studentId = 2;
            Student tempStudent = session.get(Student.class, studentId);
            System.out.println("Loaded student " + tempStudent);
            System.out.println("Courses " + tempStudent.getCourses());
            Course tempCourse1 = new Course("Tolik's cube");
            Course tempCourse2 = new Course("Hi jack course");
            tempCourse1.addStudent(tempStudent);
            tempCourse2.addStudent(tempStudent);
            session.save(tempCourse1);
            session.save(tempCourse2);
            session.getTransaction().commit();
            System.out.println("Done !");
        }
    }
}
