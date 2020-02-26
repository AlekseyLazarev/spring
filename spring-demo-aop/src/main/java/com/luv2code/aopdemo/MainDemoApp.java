package com.luv2code.aopdemo;

import com.luv2code.aopdemo.config.DemoConfig;
import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class)) {
            AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
            accountDAO.addAccount();
            accountDAO.addAccount();
        }
    }
}
