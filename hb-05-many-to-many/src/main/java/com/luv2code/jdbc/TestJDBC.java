package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class TestJDBC
 * <p>
 * Date: 16.01.2020
 *
 * @author a.lazarev
 */
public class TestJDBC {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";
        System.out.println("Connecting to DB: " + jdbcUrl);
        try (Connection connection = DriverManager.getConnection(jdbcUrl, user, pass)) {
            System.out.println("Connection successful !");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
