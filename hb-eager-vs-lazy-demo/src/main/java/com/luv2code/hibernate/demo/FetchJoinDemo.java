package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.query.Query;
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
public class FetchJoinDemo {
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
            Query<Instructor> query = session.createQuery("select i from Instructor i "
                    + "JOIN FETCH i.courses " +
                    "where i.id=:id", Instructor.class);
            query.setParameter("id", id);
            Instructor instructor = query.getSingleResult();
            System.out.println("Luv2code: Instructor: " + instructor);
            System.out.println("Luv2code: Courses: " + instructor.getCourses());
            session.getTransaction().commit();
            System.out.println("Luv2code: Done !");
        }
    }
}
