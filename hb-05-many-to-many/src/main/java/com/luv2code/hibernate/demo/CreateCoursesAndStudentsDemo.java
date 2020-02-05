package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Class CreateDemo
 * <p>
 * Date: 28.01.2020
 *
 * @author a.lazarev
 */
public class CreateCoursesAndStudentsDemo {
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
            Course course = new Course("Pacman - Hot To Score One Million Points");
            System.out.println("Saving course . . .");
            session.save(course);
            System.out.println("Saved the course " + course);
            Student s1 = new Student("John", "Doe", "some@mail.ru");
            Student s2 = new Student("Mary", "Public", "mp@mail.ru");
            course.addStudent(s1);
            course.addStudent(s2);
            System.out.println("Saving students . . .");
            session.save(s1);
            session.save(s2);
            System.out.println("Saved students " + course.getStudents());
            session.getTransaction().commit();
            System.out.println("Done !");
        }
    }
}
