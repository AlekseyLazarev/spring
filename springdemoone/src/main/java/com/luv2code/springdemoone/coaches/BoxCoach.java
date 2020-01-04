package com.luv2code.springdemoone.coaches;

import com.luv2code.springdemoone.interfaces.Coach;
import com.luv2code.springdemoone.interfaces.FortuneService;
import org.springframework.stereotype.Component;

/**
 * Class BoxCoach
 * <p>
 * Date: 04.01.2020
 *
 * @author a.lazarev
 */
@Component
public class BoxCoach implements Coach {
    private FortuneService fortuneService;

    public BoxCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkOut() {
        return "Boxing with yourself.";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }
}
