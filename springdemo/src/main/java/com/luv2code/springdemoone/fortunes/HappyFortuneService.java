package com.luv2code.springdemoone.fortunes;

import com.luv2code.springdemoone.interfaces.FortuneService;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 16.12.2019
 */
public class HappyFortuneService implements FortuneService {
    public String getFortune() {
        return "Today is your lucky day!";
    }
}
