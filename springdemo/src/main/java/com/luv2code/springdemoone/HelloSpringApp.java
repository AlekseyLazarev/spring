package com.luv2code.springdemoone;

import com.luv2code.springdemoone.interfaces.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 16.12.2019
 */
public class HelloSpringApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach theCoach = context.getBean("myCoach", Coach.class);
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        context.close();
    }
}