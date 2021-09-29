package com.example.scheduling.conditional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * created by Atiye Mousavi
 * Date: 9/26/2021
 * Time: 10:00 AM
 */

@Configuration
@Slf4j
public class ScheduledJobsWithBoolean {
    //کتابخانه Spring Scheduling به برنامه های کاربردی اجازه می دهد تا کد را در فواصل زمانی مشخص اجرا کنند. از آنجا که فواصل با استفاده
    // از@Scheduled مشخص می شوند ، فواصل معمولاً ثابت هستند و نمی توانند در طول عمر برنامه تغییر کنند.

    //ولی از طریق زیر میتوان بصورت شرطی این کار را انجام داد
    @Value("${jobs.enabled:true}")
    private boolean isEnabled;

    /**
     * A scheduled job controlled via application property. The job always
     * executes, but the logic inside is protected by a configurable boolean
     * flag.
     */
    @Scheduled(fixedDelay = 60000)
    public void cleanTempDirectory() {
        if (isEnabled) {
            log.info("Cleaning temp directory via boolean flag");
        }
    }
}
