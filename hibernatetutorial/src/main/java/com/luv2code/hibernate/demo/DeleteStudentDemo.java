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
public class DeleteStudentDemo {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            int studentId = 1;

//            System.out.println("Getting student with id: " + studentId);
//            Student myStudent = session.get(Student.class, studentId);
//
//            System.out.println("Deleting student: " + myStudent);
//            session.delete(myStudent);

            System.out.println("Deleting student id = 2");
            session.createQuery("delete from Student where id=2").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done !");

        }
    }
}
