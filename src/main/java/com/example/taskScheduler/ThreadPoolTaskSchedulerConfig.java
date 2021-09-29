package com.example.taskScheduler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.util.concurrent.TimeUnit;

/**
 * created by Atiye Mousavi
 * Date: 9/26/2021
 * Time: 11:41 AM
 */
@Configuration
@ComponentScan(basePackages = "com.example.taskScheduler",basePackageClasses = {ThreadPoolTaskSchedulerExamples.class})
public class ThreadPoolTaskSchedulerConfig {
    //ThreadPoolTaskScheduler برای مدیریت موضوع داخلی مناسب است ، زیرا وظایف خود را به ScheduledExecutorService واگذار می کند و رابط TaskExecutor را پیاده سازی می کند - به طوری که نمونه ای از آن قادر به اجرای بالقوه ناهمزمان و همچنین حاشیه نویسیScheduled است.
    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        //threadPoolTaskScheduler می تواند وظایف را بر اساس اندازه ترد پول پیکربندی شده 5 به صورت همزمان انجام دهد.
        ThreadPoolTaskScheduler threadPoolTaskScheduler=new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(5);
        threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");//توجه داشته باشید که همه نامهای موضوع ThreadPoolTaskScheduler با ThreadPoolTaskScheduler پیشوند خواهند شد.
        return threadPoolTaskScheduler;
    }
    @Bean
    public CronTrigger cronTrigger() {
        return new CronTrigger("10 * * * * ?");
    }

    @Bean
    public PeriodicTrigger periodicTrigger() {
        return new PeriodicTrigger(2000, TimeUnit.MICROSECONDS);
    }

    @Bean
    public PeriodicTrigger periodicFixedDelayTrigger() {
        //این کانفیگ ها برای ایجاد وقفه است
        PeriodicTrigger periodicTrigger = new PeriodicTrigger(2000, TimeUnit.MICROSECONDS);
        periodicTrigger.setFixedRate(true);
        //این وقفه فقط برای بار اول مقدار دهی میشود
        periodicTrigger.setInitialDelay(1000);
        return periodicTrigger;
    }
}
