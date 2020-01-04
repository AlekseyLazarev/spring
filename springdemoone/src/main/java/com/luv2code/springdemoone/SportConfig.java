package com.luv2code.springdemoone;

import com.luv2code.springdemoone.coaches.SwimCoach;
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
public class SportConfig {
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }
}
