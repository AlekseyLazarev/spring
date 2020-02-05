package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
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
public class CreateCoursesAndReviewsDemo {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Course course = new Course("Pacman - Hot To Score One Million Points");
            course.addReview(new Review("Great course ! I love it"));
            course.addReview(new Review("Cool course"));
            course.addReview(new Review("U r IDIOT!"));
            System.out.println("Saving course");
            System.out.println(course);
            System.out.println(course.getReviews());
            session.save(course);
            session.getTransaction().commit();
            System.out.println("Done !");
        }
    }
}
