package com.luv2code.springdemoone;

import com.luv2code.springdemoone.interfaces.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class AnnotationBeanScopeDemoApp
 * <p>
 * Date: 04.01.2020
 *
 * @author a.lazarev
 */
public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
        boolean result = theCoach == alphaCoach;
        System.out.println("Pointing to the same object: " + result);
        System.out.println("Memory location for theCoach: " + theCoach);
        System.out.println("Memory location for alphaCoach: " + alphaCoach);
        context.close();
    }
}
