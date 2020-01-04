package com.luv2code.springdemoone.fortunes;

import com.luv2code.springdemoone.interfaces.FortuneService;
import org.springframework.stereotype.Component;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 03.01.2020
 */
@Component
public class DatabaseFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return null;
    }
}
