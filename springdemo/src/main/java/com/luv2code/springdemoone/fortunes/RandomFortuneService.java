package com.luv2code.springdemoone.fortunes;

import com.luv2code.springdemoone.interfaces.FortuneService;

import java.util.Random;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 16.12.2019
 */
public class RandomFortuneService implements FortuneService {
    private String[] fortunes;

    public RandomFortuneService(String[] fortunes) {
        this.fortunes = fortunes;
    }
    public String getFortune() {
        return fortunes[new Random().nextInt(3)];
    }
}
