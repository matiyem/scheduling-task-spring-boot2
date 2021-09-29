package com.example.springRetry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.SQLException;

/**
 * created by Atiye Mousavi
 * Date: 9/26/2021
 * Time: 11:35 AM
 */

@Service
@Slf4j
public class MyServiceImpl implements MyService{
    @Override
    public void retryService() {
        log.info("throw RuntimeException in method retryService()");
        throw new RuntimeException();
    }

    @Override
    public void retryServiceWithRecovery(String sql) throws SQLException {
        if (StringUtils.isEmpty(sql)) {
            log.info("throw SQLException in method retryServiceWithRecovery()");
            throw new SQLException();
        }
    }

    @Override
    public void retryServiceWithCustomization(String sql) throws SQLException {
        if (StringUtils.isEmpty(sql)) {
            log.info("throw SQLException in method retryServiceWithCustomization()");
            throw new SQLException();
        }
    }

    @Override
    public void retryServiceWithExternalConfiguration(String sql) throws SQLException {
        if (StringUtils.isEmpty(sql)) {
            log.info("throw SQLException in method retryServiceWithExternalConfiguration()");
            throw new SQLException();
        }
    }

    @Override
    public void recover(SQLException e, String sql) {
        log.info("In recover method");

    }

    @Override
    public void templateRetryService() {
        log.info("throw RuntimeException in method templateRetryService()");
        throw new RuntimeException();
    }
}
