package com.example.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * created by Atiye Mousavi
 * Date: 9/26/2021
 * Time: 9:15 AM
 */
@Component
public class AsyncComponent {
    //به زبان ساده ، حاشیه نویسی یک روش لوبیا باAsync باعث می شود که در یک موضوع جداگانه اجرا شود. به عبارت دیگر ، تماس گیرنده منتظر تکمیل روش فراخوانی شده نخواهد بود.
    @Async
    public void asyncMethodWithVoidReturnType(){
        System.out.println("Execute method asynchronously. " + Thread.currentThread().getName());
    }
    @Async
    public Future<String> asyncMethodWithReturnType(){
        System.out.println("Execute method asynchronously " +Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            //از asyncResult برای trackکردن خروجی async استفاده میشود
            return new AsyncResult<>("hello world !!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Async("threadPoolTaskExecutor")
    public void asyncMethodWithConfiguredExecutor(){
        System.out.println("Execute method asynchronously with configured ex"+Thread.currentThread().getName());
    }
    @Async
    public void asyncMethodWithExceptions() throws Exception {
        throw new Exception("Throw message from asynchronous method. ");
    }
}
