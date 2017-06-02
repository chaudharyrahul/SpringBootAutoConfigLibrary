## Welcome

This sample app shows how to create Spring Boot auto configurable library

### Things to do to make library auto-configurable?

1. Create Configuration Class
2. Add Component on one of the configuration file <br> 
3. Create `spring.factories` file in `META-INF` folder under resources
4. Add configuration classes to  `spring.factories` files as below

   `org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.rc.spring.async.configuration.AsyncConfiguration`
   (Comma Separated classes)

5. Add library to apps classpath (for this example added dependancy as below)
 
 ```
 <dependency>
     <groupId>com.rc.spring</groupId>
     <artifactId>autoconfig</artifactId>
     <version>1.0.0.0-SNAPSHOT</version>
 </dependency>
 ```
6. Annotate methods that you want to Run Asynchronously with annotation `com.rc.spring.async.annotations.MyAsync` 
7. We are ready with autoconfigurable library

### Output of Sample application

```markdown
2017-06-02 23:31:50.512  INFO 4528 --- [           main] com.rc.spring.app.AppMain                : Started AppMain in 5.934 seconds (JVM running for 6.771)
2017-06-02 23:31:50.574  INFO 4528 --- [           main] com.rc.spring.app.service.TestService    : Running slowMethodWithoutAnnotation
2017-06-02 23:31:53.576  INFO 4528 --- [           main] com.rc.spring.app.service.TestService    : Finished slowMethodWithoutAnnotation
2017-06-02 23:31:53.576  INFO 4528 --- [           main] com.rc.spring.app.service.TestService    : Running slowMethodWithoutAnnotation
2017-06-02 23:31:56.576  INFO 4528 --- [           main] com.rc.spring.app.service.TestService    : Finished slowMethodWithoutAnnotation
2017-06-02 23:31:56.576  INFO 4528 --- [           main] com.rc.spring.app.service.TestService    : Running slowMethodWithoutAnnotation
2017-06-02 23:31:59.576  INFO 4528 --- [           main] com.rc.spring.app.service.TestService    : Finished slowMethodWithoutAnnotation
2017-06-02 23:31:59.587  INFO 4528 --- [ecutorDefault-1] com.rc.spring.app.service.TestService    : Running slowMethodWithAnnotationWithoutParam
2017-06-02 23:31:59.588  INFO 4528 --- [ecutorDefault-2] com.rc.spring.app.service.TestService    : Running slowMethodWithAnnotationWithoutParam
2017-06-02 23:31:59.588  INFO 4528 --- [ecutorDefault-3] com.rc.spring.app.service.TestService    : Running slowMethodWithAnnotationWithoutParam
2017-06-02 23:31:59.588  INFO 4528 --- [    executor2-1] com.rc.spring.app.service.TestService    : Running slowMethodWithAnnotationWithParam
2017-06-02 23:31:59.589  INFO 4528 --- [    executor2-2] com.rc.spring.app.service.TestService    : Running slowMethodWithAnnotationWithParam
2017-06-02 23:31:59.590  INFO 4528 --- [    executor2-3] com.rc.spring.app.service.TestService    : Running slowMethodWithAnnotationWithParam
2017-06-02 23:32:02.587  INFO 4528 --- [ecutorDefault-1] com.rc.spring.app.service.TestService    : Finished slowMethodWithAnnotationWithoutParam
2017-06-02 23:32:02.588  INFO 4528 --- [ecutorDefault-2] com.rc.spring.app.service.TestService    : Finished slowMethodWithAnnotationWithoutParam
2017-06-02 23:32:02.588  INFO 4528 --- [    executor2-1] com.rc.spring.app.service.TestService    : Finished slowMethodWithAnnotationWithParam
2017-06-02 23:32:02.588  INFO 4528 --- [ecutorDefault-3] com.rc.spring.app.service.TestService    : Finished slowMethodWithAnnotationWithoutParam
2017-06-02 23:32:02.589  INFO 4528 --- [    executor2-2] com.rc.spring.app.service.TestService    : Finished slowMethodWithAnnotationWithParam
2017-06-02 23:32:02.590  INFO 4528 --- [    executor2-3] com.rc.spring.app.service.TestService    : Finished slowMethodWithAnnotationWithParam

```
