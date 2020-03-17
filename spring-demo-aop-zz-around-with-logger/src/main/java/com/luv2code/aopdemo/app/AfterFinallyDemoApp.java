package com.luv2code.aopdemo.app;

import com.luv2code.aopdemo.config.DemoConfig;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class)) {
            AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
            List<Account> theAccounts = null;
            try {
                boolean tripWire = false;
                theAccounts = accountDAO.findAccounts(tripWire);
            } catch (Exception exc) {
                System.out.println("Main program exception " + exc);
            }

            System.out.println("Main Program: AfterThrowingDemoApp");
            System.out.println("-----");
            System.out.println(theAccounts);
        }
    }
}
