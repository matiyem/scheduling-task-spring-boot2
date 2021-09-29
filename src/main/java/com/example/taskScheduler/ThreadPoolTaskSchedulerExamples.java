package com.example.taskScheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * created by Atiye Mousavi
 * Date: 9/26/2021
 * Time: 1:38 PM
 */
@Component
public class ThreadPoolTaskSchedulerExamples {

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    @Autowired
    private CronTrigger cronTrigger;

    @Autowired
    private PeriodicTrigger periodicTrigger;

    @PostConstruct
    public void scheduleRunnableWithCronTrigger() {
        taskScheduler.schedule(new RunnableTask("Current Date"), new Date());//اکنون می توانیم این وظیفه را ساده برنامه ریزی کنیم تا توسط زمانبند اجرا شود
        //یکی از مکانیزم های ایجاد وقفه به صورت زیر است که تسک بعد از یک ثانیه اجرا میشود.بین دو اجرا یک ثانیه وقفه ایجاد میشود
        taskScheduler.scheduleWithFixedDelay(new RunnableTask("Fixed 1 second Delay"), 1000);
        taskScheduler.scheduleWithFixedDelay(new RunnableTask("Current Date Fixed 1 second Delay"), new Date(), 1000);
        //یکی دیگر از مکانیزم های ایجاد وقفه بصورت زیر است یعنی هر زمان که postContruct اجرا شود با وقفه 2 ثانیه اجرا میشود
        taskScheduler.scheduleAtFixedRate(new RunnableTask("Fixed Rate of 2 seconds"), new Date(), 2000);
        taskScheduler.scheduleAtFixedRate(new RunnableTask("Fixed Rate of 2 seconds"), 2000);
        // با استفاده از cronExperssion اجرا میشود
        taskScheduler.schedule(new RunnableTask("Cron Trigger"), cronTrigger);
        taskScheduler.schedule(new RunnableTask("Periodic Trigger"), periodicTrigger);
    }

    class RunnableTask implements Runnable{
        private String message;

        public RunnableTask(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.println("Runnable Task with " + message + " on thread " + Thread.currentThread().getName());

        }
    }
}
