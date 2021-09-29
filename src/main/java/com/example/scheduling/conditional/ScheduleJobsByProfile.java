package com.example.scheduling.conditional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * created by Atiye Mousavi
 * Date: 9/26/2021
 * Time: 10:25 AM
 */

@Configuration
@Slf4j
public class ScheduleJobsByProfile {
    //این روش مشابه استفاده ازConditionalOnProperty عمل می کند
    //زمانی این bean ساخته میشود که پروفایل prod فعال باشد
    //نکته ای که در این روش باید به آن توجه داشت این است که اگر اصلاً پروفایل مشخص نشده باشد ، روش bean اجرا می شود.
    @Profile("prod")
    @Bean
    public ScheduledJob scheduledJob(){
        return new ScheduledJob("@Profile");
    }
}
