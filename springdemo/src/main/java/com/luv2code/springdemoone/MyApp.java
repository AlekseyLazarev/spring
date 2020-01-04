package com.luv2code.springdemoone;

import com.luv2code.springdemoone.coaches.TrackCoach;
import com.luv2code.springdemoone.interfaces.Coach;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 16.12.2019
 */
public class MyApp {
    public static void main(String[] args) {
        Coach theCoach = new TrackCoach();
        System.out.println(theCoach.getDailyWorkout());
    }
}