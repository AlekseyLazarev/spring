package com.luv2code.aopdemo;

import com.luv2code.aopdemo.config.DemoConfig;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class)) {
            AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
            List<Account> theAccounts = accountDAO.findAccounts();
            System.out.println("Main Program: AfterReturningDemoApp");
            System.out.println("-----");
            System.out.println(theAccounts);
        }
    }
}
