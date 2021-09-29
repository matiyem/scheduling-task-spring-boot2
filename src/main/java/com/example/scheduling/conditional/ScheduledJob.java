package com.example.scheduling.conditional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * created by Atiye Mousavi
 * Date: 9/26/2021
 * Time: 9:58 AM
 */
@Slf4j
public class ScheduledJob {

    private String source;

    public ScheduledJob(String source) {
        this.source = source;
    }
    @Scheduled(fixedDelay = 6000)
    public void cleanTemDir(){
        log.info("Cleaning temp directory via {} ",source);
    }
}
