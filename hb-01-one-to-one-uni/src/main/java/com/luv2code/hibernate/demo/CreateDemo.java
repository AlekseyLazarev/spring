package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Class CreateDemo
 * <p>
 * Date: 21.01.2020
 *
 * @author a.lazarev
 */
public class CreateDemo {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("htttp://www.youtube.com/", "guitar");
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            session.beginTransaction();
            System.out.println("Saving instructor " + tempInstructor);
            session.save(tempInstructor);
            session.getTransaction().commit();
            System.out.println("Done !");
        }
    }
}
