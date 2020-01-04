package com.luv2code.springdemoone.coaches;

import com.luv2code.springdemoone.interfaces.Coach;
import com.luv2code.springdemoone.interfaces.FortuneService;

/**
 * Class  решение задачи части
 *
 * @author Aleksey Lazarev
 * @since 16.12.2019
 */
public class TrackCoach implements Coach {
    private FortuneService fortuneService;

    public TrackCoach() {
    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    public String getDailyFortune() {
        return "Just Do It: " + fortuneService.getFortune();
    }

    public void doMyStartupStaff() {
        System.out.println("TrackCoach: inside method doMyStartupStaff");
    }

    public void doMyCleanupStaff() {
        System.out.println("TrackCoach: inside method doMyCleanupStaff");
    }
}