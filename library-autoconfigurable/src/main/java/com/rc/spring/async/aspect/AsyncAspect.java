package com.rc.spring.async.aspect;

import com.rc.spring.async.annotations.MyAsync;
import com.rc.spring.async.constants.AsyncExecutor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

@Aspect
@Component
public class AsyncAspect {

    private static final Logger logger = LoggerFactory.getLogger(AsyncAspect.class);

    private Executor executor1;
    private Executor executor2;
    private Executor executorDefault;

    @Autowired
    public AsyncAspect(Executor executor1, Executor executor2, Executor executorDefault) {
        this.executor1 = executor1;
        this.executor2 = executor2;
        this.executorDefault = executorDefault;
    }

    @Around("@annotation(com.rc.spring.async.annotations.MyAsync)")
    public void asyncAspect(ProceedingJoinPoint proceedingJoinPoint) {

        MyAsync annotation = ((MethodSignature) proceedingJoinPoint.getSignature())
                                .getMethod().getAnnotation(MyAsync.class);

        if (AsyncExecutor.EXECUTOR_1.equals(annotation.executor())) {
            executor1.execute(getRunnable(proceedingJoinPoint));
        }else if (AsyncExecutor.EXECUTOR_2.equals(annotation.executor())) {
            executor2.execute(getRunnable(proceedingJoinPoint));
        } else {
            executorDefault.execute(getRunnable(proceedingJoinPoint));
        }

    }

    private Runnable getRunnable(ProceedingJoinPoint proceedingJoinPoint) {
        return () -> {
            try {
                proceedingJoinPoint.proceed();
            } catch (Throwable throwable) {
                logger.error("Unable to execute method in executor", throwable);
            }
        };
    }

}
