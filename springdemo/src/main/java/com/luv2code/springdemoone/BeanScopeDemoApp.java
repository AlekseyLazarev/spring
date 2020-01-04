package com.luv2code.springdemoone;

import com.luv2code.springdemoone.interfaces.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 03.01.2020
 */
public class BeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        Coach theCoach = context.getBean("myCoach", Coach.class);

        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        boolean result = theCoach == alphaCoach;

        System.out.println("Pointing to the same object " + result);

        System.out.println("Memory loaction for theCoach: " + theCoach);

        System.out.println("Memory loaction for alphaCoach: " + alphaCoach);
        context.close();
    }
}
