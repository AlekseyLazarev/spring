package com.luv2code.springdemoone.coaches;

import com.luv2code.springdemoone.interfaces.Coach;
import com.luv2code.springdemoone.interfaces.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 03.01.2020
 */
@Component
public class SwimCoach implements Coach {
    @Autowired
    @Qualifier("fileFortuneService")
    private FortuneService fortuneService;

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    @Override
    public String getDailyWorkOut() {
        return "Swim swim swim";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }
}