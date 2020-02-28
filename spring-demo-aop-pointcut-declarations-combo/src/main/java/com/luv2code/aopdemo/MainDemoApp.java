package com.luv2code.aopdemo;

import com.luv2code.aopdemo.config.DemoConfig;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class)) {
            AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
            accountDAO.addAccount(new Account(), true);
            accountDAO.doWork();
            accountDAO.setName("foobar");
            accountDAO.setServiceCode("Silver");
            String name = accountDAO.getName();
            String serviceCode = accountDAO.getServiceCode();
            MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
            membershipDAO.addMembership();
            membershipDAO.goToSleep();
        }
    }
}
