package com.in28minutes.learnspringaop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Around("execution(* com.in28minutes.learnspringaop.aopexample.*.*.*(..))")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Start a timer 
        
        long startTimeMills = System.currentTimeMillis();

        // Execute the method.

        Object returnValue = proceedingJoinPoint.proceed();

        // stop the timer.
        long stopTimeMills = System.currentTimeMillis();
        long executionDuration = stopTimeMills - startTimeMills;

        logger.info("Around Aspect - {} Method executed in {} ms", proceedingJoinPoint, executionDuration);

        return returnValue;
    }
}
