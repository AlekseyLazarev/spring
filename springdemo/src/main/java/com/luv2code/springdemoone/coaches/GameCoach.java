package com.luv2code.springdemoone.coaches;

import com.luv2code.springdemoone.interfaces.Coach;
import com.luv2code.springdemoone.interfaces.FortuneService;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 03.01.2020
 */
public class GameCoach implements Coach {
    private FortuneService fortuneService;

    public GameCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    public String getDailyWorkout() {
        return "Gaming all day";
    }

    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }
}
