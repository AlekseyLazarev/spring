package com.luv2code.springdemoone;

import com.luv2code.springdemoone.coaches.BoxCoach;
import com.luv2code.springdemoone.fortunes.SadFortuneService;
import com.luv2code.springdemoone.interfaces.Coach;
import com.luv2code.springdemoone.interfaces.FortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Class SportConfig
 * <p>
 * Date: 04.01.2020
 *
 * @author a.lazarev
 */
@Configuration
@PropertySource("sport.properties")
public class PracticeConfig {
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    @Bean
    public Coach boxCoach() {
        return new BoxCoach(sadFortuneService());
    }
}
