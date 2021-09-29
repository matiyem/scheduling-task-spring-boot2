package com.example.springRetry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

import java.sql.SQLException;

/**
 * created by Atiye Mousavi
 * Date: 9/26/2021
 * Time: 11:31 AM
 */

public interface MyService {

    @Retryable
    void retryService();

    //زمانی که این ارور برگرداننده شود دوبارع  اجرا میشود بصورت دیفالت سه بار اجرا میشود به فاصه یک ثانیه
    //در نتیجه ، اگر متد retryServiceWithRecovery همچنان پس از سه بار تلاش SqlException را پرتاب کند ، متد () recovery فراخوانی می شود.
    @Retryable(value = SQLException.class)
    void retryServiceWithRecovery(String sql) throws SQLException;
    //ورودی backOff برای تعیین فاصله زمانی بین اجرا مجدد است
    //رودی maxAttempt برای تعداد اجراهای مجدد است که بصورت دیفالت 3 بار است
    @Retryable(value = {SQLException.class},maxAttempts = 2,backoff = @Backoff(delay = 100))
    void retryServiceWithCustomization(String sql) throws SQLException;

    //وقتی داریم از فایل پراپرتی استفاده میکنیم یا به عنوان مثال هارد کدی بدهیم باید به روش زیر استفاده کنیم یعنی  maxAttemptsExpression بجایmaxAttempts
    @Retryable(value = SQLException.class,maxAttemptsExpression ="${retry.maxAttempts}",
    backoff = @Backoff(delayExpression = "${retry.maxDelay}"))
    void retryServiceWithExternalConfiguration(String sql) throws SQLException;
    // یک روش بازیابی جداگانه را زمانی مشخص می کند که یک روشRetryable با یک استثنا مشخص مشخص نشود.
    @Recover
    void recover(SQLException e, String sql);

    void templateRetryService();

}
