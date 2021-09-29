package com.example.scheduling.dynamic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * created by Atiye Mousavi
 * Date: 9/26/2021
 * Time: 10:26 AM
 */
@Configuration
@ComponentScan("com.example.scheduling.dynamic")
@EnableScheduling
public class DynamicSchedulingConfig implements SchedulingConfigurer {
    //10. Setting Delay or Rate Dynamically at Runtime
    @Autowired
    private TickService tickService;

    @Bean
    public Executor taskExecutor() {
        return Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
        taskRegistrar.addTriggerTask(() -> tickService.tick(),context ->{
            Optional<Date> lastCompletionTime=Optional.ofNullable(context.lastCompletionTime());
            Instant nextExecutionTime=lastCompletionTime.orElseGet(Date::new).toInstant()
                    .plusMillis(tickService.getDelay());
            return Date.from(nextExecutionTime);
        });
    }
}
