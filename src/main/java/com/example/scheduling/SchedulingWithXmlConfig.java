package com.example.scheduling;

/**
 * created by Atiye Mousavi
 * Date: 9/26/2021
 * Time: 11:16 AM
 */

public class SchedulingWithXmlConfig {

    public void scheduleFixedDelayTask() {
        System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);
    }

    public void scheduleFixedRateTask() {
        System.out.println("Fixed rate task - " + System.currentTimeMillis() / 1000);
    }

    public void scheduleTaskUsingCronExpression() {
        System.out.println("schedule tasks using cron expressions - " + System.currentTimeMillis() / 1000);
    }}
