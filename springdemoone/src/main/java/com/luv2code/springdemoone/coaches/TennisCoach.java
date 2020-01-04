package com.luv2code.springdemoone.coaches;

import com.luv2code.springdemoone.interfaces.Coach;
import com.luv2code.springdemoone.interfaces.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 03.01.2020
 */
@Component
public class TennisCoach implements Coach {
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    @Override
    public String getDailyWorkOut() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }
}
