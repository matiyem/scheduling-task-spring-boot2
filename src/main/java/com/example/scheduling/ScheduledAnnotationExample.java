package com.example.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * created by Atiye Mousavi
 * Date: 9/26/2021
 * Time: 10:43 AM
 */

@Component("scheduledAnnotationExample")
public class ScheduledAnnotationExample {
    //کانفیگ کردن یک تسک برای اجرا با وقفه
    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        //تسک بعدی همیشه زمانی اجرا میشود که تسک قبلی اجرا و تمام شود
        System.out.println("fixed delay task - " + System.currentTimeMillis() / 1000);
    }
    //میتوان بصورت پارامتری ارسال کرد
    @Scheduled(fixedRateString = "${fixedDelay.in.milliseconds}")
    public void schedualFixedDelayWithInitialDelayTask() {
        System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);

    }

    @Scheduled(fixedDelay = 1000, initialDelay = 2000)
    public void scheduleFixedDelayWithInitialDelayTask() {
        System.out.println("Fixed delay task with one second initial delay - " + System.currentTimeMillis() / 1000);
    }

    //    این گزینه باید زمانی استفاده شود که هر یک از وظایف مستقل باشد.
//
//توجه داشته باشید که کارهای برنامه ریزی شده به طور پیش فرض موازی اجرا نمی شوند. بنابراین حتی اگر از fixedRate استفاده کردیم ، تا زمانی که کار قبلی انجام نشود ، کار بعدی فراخوانی نمی شود.
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
        System.out.println("Fixed rate task - " + System.currentTimeMillis() / 1000);
    }

    @Scheduled(fixedRateString = "${fixedRate.in.milliseconds}")
    public void scheduleFixedRateTaskUsingExpression() {
        System.out.println("Fixed rate task - " + System.currentTimeMillis() / 1000);
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void scheduleFixedRateWithInitialDelayTask() {
        long now = System.currentTimeMillis() / 1000;
        System.out.println("Fixed rate task with one second initial delay - " + now);
    }

    /**
     * Scheduled task is executed at 10:15 AM on the 15th day of every month
     */
    @Scheduled(cron = "0 15 10 15 * ?")
    public void scheduleTaskUsingCronExpression() {
        long now = System.currentTimeMillis() / 1000;
        System.out.println("schedule tasks using cron jobs - " + now);

    }
    //روش بعدی برای اجرای شرطی متد استفاده cronExpression ها است
    @Scheduled(cron = "${cron.expression}")
    public void scheduleTaskUsingExternalizedCronExpression() {
        System.out.println("schedule tasks using externalized cron expressions - " + System.currentTimeMillis() / 1000);

    }
}
