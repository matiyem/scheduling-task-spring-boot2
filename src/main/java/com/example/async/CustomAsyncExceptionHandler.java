package com.example.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * created by Atiye Mousavi
 * Date: 9/26/2021
 * Time: 9:12 AM
 */

public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(final Throwable ex,final Method method,final Object... params) {
        //اما اگر نوع بازگشت void باشد ، موارد استثنا در thread فراخوان منتشر نمی شوند. بنابراین ، ما باید تنظیمات اضافی را برای رسیدگی به موارد استثنا اضافه کنیم.

        //با پیاده سازی رابط AsyncUncaughtExceptionHandler ، یک استثناء سفارشی سفارشی ایجاد می کنیم. متد () handleUncaughtException زمانی فراخوانی می شود که استثنائات ناهمزمان غیرقابل کشف وجود داشته باشد:
        System.out.println("Exception message - " + ex.getMessage());
        System.out.println("Method name - " + method.getName());
        for (final Object param: params){
            System.out.println("Param - "+ param);
        }

    }
}
