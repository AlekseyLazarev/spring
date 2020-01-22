package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Class PrimaryKeyDemo
 * <p>
 * Date: 21.01.2020
 *
 * @author a.lazarev
 */
public class PrimaryKeyDemo {
    public static void main(String[] args) {
        try(SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()){
            Session session = factory.getCurrentSession();
            System.out.println("Creating 3 student object . . .");
            session.beginTransaction();
            System.out.println("Saving the students . . .");
            session.save(new Student("John", "Doe", "john@luv2code.com"));
            session.save(new Student("Mary", "Public", "mary@luv2code.com"));
            session.save(new Student("Bonita", "Applebum", "bonita@luv2code.com"));
            session.getTransaction().commit();
            System.out.println("Done !");
        }
    }
}
