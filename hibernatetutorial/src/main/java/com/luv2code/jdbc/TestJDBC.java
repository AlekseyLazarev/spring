package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class TestJDBC
 * <p>
 * Date: 16.01.2020
 *
 * @author a.lazarev
 */
public class TestJDBC {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";
        try {
            System.out.println("Connecting to DB: " + jdbcUrl);
            Connection connection = DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("Connection successful !");

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
