package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Class GetInstructorDetailDemo
 * <p>
 * Date: 23.01.2020
 *
 * @author a.lazarev
 */
public class GetInstructorDetailDemo {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            int id = 2110;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println("Instructor Detail: " + instructorDetail);
            System.out.println("Associated instructor: " + instructorDetail.getInstructor());
            session.getTransaction().commit();
            System.out.println("Done !");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
