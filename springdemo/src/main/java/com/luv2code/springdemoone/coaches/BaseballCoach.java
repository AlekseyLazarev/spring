package com.luv2code.springdemoone.coaches;

import com.luv2code.springdemoone.interfaces.Coach;
import com.luv2code.springdemoone.interfaces.FortuneService;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 16.12.2019
 */
public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}