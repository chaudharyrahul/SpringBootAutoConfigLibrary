package com.rc.spring.app.service;

import com.rc.spring.async.annotations.MyAsync;
import com.rc.spring.async.constants.AsyncExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private static final Logger logger = LoggerFactory.getLogger(TestService.class);

    public void slowMethodWithoutAnnotation() {
        logger.info("Running slowMethodWithoutAnnotation");
        sleep();
        logger.info("Finished slowMethodWithoutAnnotation");
    }

    @MyAsync
    public void slowMethodWithAnnotationWithoutParam() {
        logger.info("Running slowMethodWithAnnotationWithoutParam");
        sleep();
        logger.info("Finished slowMethodWithAnnotationWithoutParam");
    }

    @MyAsync(executor = AsyncExecutor.EXECUTOR_2)
    public void slowMethodWithAnnotationWithParam() {
        logger.info("Running slowMethodWithAnnotationWithParam");
        sleep();
        logger.info("Finished slowMethodWithAnnotationWithParam");
    }



    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            logger.error("Interrupted",e);
        }
    }


}
