package com.luv2code.springdemoone.coaches;

import com.luv2code.springdemoone.interfaces.Coach;
import com.luv2code.springdemoone.interfaces.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 03.01.2020
 */
@Component
public class PingPongCoach implements Coach {
    @Override
    public String getDailyWorkOut() {
        return "Ping pong now !";
    }

    @Override
    public String getDailyFortune() {
        return "Have a nice day!";
    }
}
