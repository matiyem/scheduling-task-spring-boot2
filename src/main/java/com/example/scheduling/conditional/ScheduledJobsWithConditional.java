package com.example.scheduling.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * created by Atiye Mousavi
 * Date: 9/26/2021
 * Time: 10:02 AM
 */
@Configuration
public class ScheduledJobsWithConditional {

    /**
     * This uses @ConditionalOnProperty to conditionally create a bean, which itself
     * is a scheduled job.
     * @return ScheduledJob
     */
    //روش بعدی برای اجرای شرطی Scheduled@
    //در این حالت ، اگر Properties jobs.enabled روی true تنظیم شده باشد یا اصلاً وجود نداشته باشد ، کار اجرا می شود. نکته منفی این است که این حاشیه نویسی فقط در Spring Boot موجود است.
    @Bean
    @ConditionalOnProperty(value = "jobs.enabled",matchIfMissing = true,havingValue ="true")
    public ScheduledJob runMyCornTask(){
        return new ScheduledJob("@ConditionalOnProperty");
    }
}
