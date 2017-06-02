package com.rc.spring.async.annotations;

import com.rc.spring.async.constants.AsyncExecutor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAsync {
    String executor() default AsyncExecutor.DEFAULT;
}
