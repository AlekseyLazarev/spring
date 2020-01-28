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
public class CreateInstructorDemo {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Instructor tempInstructor = new Instructor("Susan", "Public", "susan.public@luv2code.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("htttp://www.youtube.com/", "Video Games");
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            System.out.println("Saving instructor " + tempInstructor);
            session.save(tempInstructor);
            session.getTransaction().commit();
            System.out.println("Done !");
        }
    }
}
