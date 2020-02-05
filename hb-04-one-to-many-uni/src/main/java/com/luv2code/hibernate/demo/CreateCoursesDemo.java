package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
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
public class CreateCoursesDemo {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);
            Course course1 = new Course("Air Guitar - The Ultimate Guide");
            Course course2 = new Course("The pinball masterclass");
            instructor.add(course1);
            instructor.add(course2);
            session.save(course1);
            session.save(course2);
            session.getTransaction().commit();
            System.out.println("Done !");
        }
    }
}
