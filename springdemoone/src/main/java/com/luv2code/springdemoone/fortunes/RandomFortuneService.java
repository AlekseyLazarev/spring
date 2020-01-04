package com.luv2code.springdemoone.fortunes;

import com.luv2code.springdemoone.interfaces.FortuneService;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 03.01.2020
 */
@Component
public class RandomFortuneService implements FortuneService {
    private final String[] data = {"Beware of the wolf in sheep's clothing",
            "Deligence is the mother of good luck",
            "The journey is the reward"};
    private final Random random = new Random();

    @Override
    public String getFortune() {
        return this.data[this.random.nextInt(this.data.length)];
    }
}
