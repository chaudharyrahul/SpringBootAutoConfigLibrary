package com.rc.spring.async.configuration;

import com.rc.spring.async.constants.AsyncExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@ComponentScan({"com.rc.spring"})
public class AsyncConfiguration {

    @Bean(name = AsyncExecutor.DEFAULT)
    public Executor executorDefault() {
        return getExecutor();
    }

    @Bean(name = AsyncExecutor.EXECUTOR_1)
    public Executor executor1() {
        return getExecutor();
    }

    @Bean(name = AsyncExecutor.EXECUTOR_2)
    public Executor executor2() {
        return getExecutor();
    }

    private Executor getExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        return taskExecutor;
    }


}
