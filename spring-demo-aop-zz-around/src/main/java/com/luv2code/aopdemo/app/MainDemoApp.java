package com.luv2code.aopdemo.app;

import com.luv2code.aopdemo.config.DemoConfig;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class)) {
            AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
            Account account = new Account();
            account.setLevel("Platinum");
            account.setName("Madhu");
            accountDAO.addAccount(account, true);
            accountDAO.doWork();
            accountDAO.setName("foobar");
            accountDAO.setServiceCode("Silver");
            accountDAO.getName();
            accountDAO.getServiceCode();
            MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
            membershipDAO.addMembership();
            membershipDAO.goToSleep();
        }
    }
}
