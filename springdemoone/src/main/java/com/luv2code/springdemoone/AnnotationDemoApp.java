package com.luv2code.springdemoone;

import com.luv2code.springdemoone.interfaces.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 03.01.2020
 */
public class AnnotationDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach theCoach = context.getBean("swimCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkOut());

        System.out.println(theCoach.getDailyFortune());

        context.close();
    }
}
