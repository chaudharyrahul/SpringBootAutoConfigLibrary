package com.rc.spring.app;

import com.rc.spring.app.service.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AppMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AppMain.class);

        TestService service = context.getBean(TestService.class);

        // Should Run on main Thread
        service.slowMethodWithoutAnnotation();
        service.slowMethodWithoutAnnotation();
        service.slowMethodWithoutAnnotation();

        // Should Run on default executor
        service.slowMethodWithAnnotationWithoutParam();
        service.slowMethodWithAnnotationWithoutParam();
        service.slowMethodWithAnnotationWithoutParam();

        // Should Run on parametrised executor
        service.slowMethodWithAnnotationWithParam();
        service.slowMethodWithAnnotationWithParam();
        service.slowMethodWithAnnotationWithParam();

    }

}
