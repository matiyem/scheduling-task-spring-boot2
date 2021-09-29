package com.example.scheduling;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * created by Atiye Mousavi
 * Date: 9/26/2021
 * Time: 11:15 AM
 */
@Component
@EnableAsync
public class ScheduledFixedRateExample {

    @Async
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTaskAsync() throws InterruptedException {
        System.out.println("Fixed rate task async - " + System.currentTimeMillis() / 1000);
        Thread.sleep(2000);
    }
}
