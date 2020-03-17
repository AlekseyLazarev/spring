package com.luv2code.aopdemo.app;

import com.luv2code.aopdemo.config.DemoConfig;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.entity.Account;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class)) {
            TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
            System.out.println("Main program: AroundDemoApp");
            System.out.println("Calling getFortune");
            String data = theTrafficFortuneService.getFortune();
            System.out.println("My fortune is: " + data);
            System.out.println("Finished");
        }
    }
}
