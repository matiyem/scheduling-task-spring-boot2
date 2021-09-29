package com.example.springretry;

import com.example.springRetry.AppConfig;
import com.example.springRetry.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class SpringRetryIntegrationTest {

    @Autowired
    private MyService myService;

    @Autowired
    private RetryTemplate retryTemplate;

    @Test(expected = RuntimeException.class)
    public void givenRetryService_whenCallWithException_thenRetry() {
        myService.retryService();
    }

    @Test
    public void givenRetryServiceWithRecovery_whenCallWithException_thenRetryRecover() throws SQLException {
        myService.retryServiceWithRecovery(null);
    }

    @Test
    public void givenRetryServiceWithCustomization_whenCallWithException_thenRetryRecover() throws SQLException {
        myService.retryServiceWithCustomization(null);
    }

    @Test
    public void givenRetryServiceWithExternalConfiguration_whenCallWithException_thenRetryRecover() throws SQLException {
        myService.retryServiceWithExternalConfiguration(null);
    }

    @Test(expected = RuntimeException.class)
    public void givenTemplateRetryService_whenCallWithException_thenRetry() {
        //این کد بهتر از کد زیر میباشد
        //retryTemplate.execute(new RetryCallback<Void, RuntimeException>() {
        //    @Override
        //    public Void doWithRetry(RetryContext arg0) {
        //        myService.templateRetryService();
        //        ...
        //    }
        //});






        //وقتی میخواهیم یک retryTemplate را اجرا کنیم به روش زیر عمل میکنیم
        retryTemplate.execute(arg0 -> {
            myService.templateRetryService();
            return null;
        });
    }
}
