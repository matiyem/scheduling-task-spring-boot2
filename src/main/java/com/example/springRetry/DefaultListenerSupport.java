package com.example.springRetry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.listener.RetryListenerSupport;

/**
 * created by Atiye Mousavi
 * Date: 9/26/2021
 * Time: 11:26 AM
 */

@Slf4j
public class DefaultListenerSupport extends RetryListenerSupport {
    //listener ها امکانات اضافی برای retry کردن ها ارایه میدهند

    //متدهای open و close قبل و بعد از اجرا انجام میشود در صورتی که onError در زمان ReTry انجا میشود
    @Override
    public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        log.info("onClose");
        super.close(context, callback, throwable);
    }

    @Override
    public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        log.info("onError");
        super.onError(context, callback, throwable);
    }

    @Override
    public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
        log.info("onOpen");
        return super.open(context, callback);
    }
}
