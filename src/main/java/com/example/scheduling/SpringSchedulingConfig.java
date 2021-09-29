package com.example.scheduling;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * created by Atiye Mousavi
 * Date: 9/26/2021
 * Time: 11:19 AM
 */
@Configuration
@EnableScheduling
@ComponentScan("com.example.scheduling")
@PropertySource("classpath:springScheduled.properties")
public class SpringSchedulingConfig {

    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
