package com.luv2code.springdemoone;

import com.luv2code.springdemoone.coaches.CricketCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 16.12.2019
 */
public class SetterDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getEmailAddress());
        System.out.println(theCoach.getTeam());
        context.close();
    }

}






