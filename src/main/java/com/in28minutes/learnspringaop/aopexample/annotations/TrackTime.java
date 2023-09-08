package com.in28minutes.learnspringaop.aopexample.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// methods.
@Target(ElementType.METHOD)
// want to use this at runtime.
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackTime {
    
}
