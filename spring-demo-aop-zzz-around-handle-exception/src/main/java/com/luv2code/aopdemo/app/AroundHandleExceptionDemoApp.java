package com.luv2code.aopdemo.app;

import com.luv2code.aopdemo.config.DemoConfig;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {
    private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class)) {
            TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
            logger.info("Main program: AroundHandleExceptionDemoApp");
            logger.info("Calling getFortune");
            boolean tripWire = true;
            String data = theTrafficFortuneService.getFortune(tripWire);
            logger.info("My fortune is: " + data);
            logger.info("Finished");
        }
    }
}
