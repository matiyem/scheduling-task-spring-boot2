package com.example.async.config;

import com.example.async.CustomAsyncExceptionHandler;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * created by Atiye Mousavi
 * Date: 9/26/2021
 * Time: 9:00 AM
 */
@Configuration
//این annotation بصورت پیشفرض Async@ و EJB 3.1 javax.ejb.Asynchronous را تشخیص میدهد
//ورودی mod حالت advice که باید استفاده شود را مشخص میکند یا از نوع JDK proxy است یا aspect weaving
//ورودی proxyTarget نوع پروکسی مورد استفاده را مشخص میکند و فقط زمانی کاربرد دارد که mod بر روی AdviceMode.PROXY ست شده باشد
@EnableAsync//برای فعال سازی async است
@ComponentScan("com.example.async")
public class SpringAsyncConfig implements AsyncConfigurer {








    // این Async@ باید بر روی متد های public قرار بگیرد و اینکه برای call کردن داخل همان کلاس کار نمیکند.یعنی نمیتواند در یک کلاس هم تعریف شود و هم call شود
    //دلایل آن ساده است: این روش باید public باشد تا بتوان از آن استفاده کرد. و خود فراخوانی کار نمی کند زیرا از پروکسی دور می زند وmethod اصلی را مستقیماً فراخوانی می کند.
    @Bean(name = "threadPoolTaskExecutor")
    public Executor threadPoolTaskExecuter(){
        return new ThreadPoolTaskExecutor();
    }

    @Override
    public Executor getAsyncExecutor() {
        return new SimpleAsyncTaskExecutor();
    }
    //برای پیاده سازی custom asynchronous exception
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new CustomAsyncExceptionHandler();
    }
}
