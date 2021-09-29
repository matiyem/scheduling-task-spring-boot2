package com.example.springRetry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * created by Atiye Mousavi
 * Date: 9/26/2021
 * Time: 11:21 AM
 */
@Configuration
@ComponentScan(basePackages = "com.example.springRetry")
@EnableRetry//برای فعال سازی retry است
@PropertySource("classpath:retryConfig.properties")//این فایل رو import میکنیم و میتونیم از پراپرتی های داخل آن استفاده کنیم
public class AppConfig {
    //Spring Retry توانایی فراخوانی مجدد یک عملیات شکست خورده را فراهم می کند. این در مواردی که خطاها ممکن است گذرا باشند (مانند یک اشکال لحظه ای شبکه) مفید است.

    @Bean
    public RetryTemplate retryTemplate(){
        //RetryPolicy تعیین می کند که چه زمانی یک عمل باید دوباره امتحان شود.
        RetryTemplate retryTemplate=new RetryTemplate();

        FixedBackOffPolicy fixedBackOffPolicy=new FixedBackOffPolicy();
        //فاصله بین اجرا ها
        fixedBackOffPolicy.setBackOffPeriod(2000l);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);
        //این کانفیگ برای تعداد اجراها
        SimpleRetryPolicy retryPolicy=new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(2);
        retryTemplate.setRetryPolicy(retryPolicy);
        //در این قسمت listener را رجیستر میکنیم
        retryTemplate.registerListener(new DefaultListenerSupport());
        return retryTemplate;
    }
}
