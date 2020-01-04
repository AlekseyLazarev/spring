package com.luv2code.springdemoone.fortunes;

import com.luv2code.springdemoone.interfaces.FortuneService;
import org.springframework.stereotype.Component;

/**
 * Class SadFortuneService
 * <p>
 * Date: 04.01.2020
 *
 * @author a.lazarev
 */
@Component
public class SadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is a sad day";
    }
}
