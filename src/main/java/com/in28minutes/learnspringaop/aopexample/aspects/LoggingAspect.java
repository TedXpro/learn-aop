package com.in28minutes.learnspringaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect // defining the class is asspect.
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // @Before - Do Something before a method is called.
    @Before("com.in28minutes.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()") // PointCut - when logic is
                                                                                // applied.
    public void logMethodBeforeExecution(JoinPoint joinPoint) {

        // login what to do?
        logger.info("Before Aspect - {} is called - {}", joinPoint, joinPoint.getArgs());

    }

    // @After - do something after a method is executed irrespective of whether
    // 1. Method throws exception or
    // 2. Method executes Successfully.
    @After("com.in28minutes.learnspringaop.aopexample.aspects.CommonPointcutConfig.dataPackageConfig()") // PointCut - when logic is
                                                                               // applied.
    public void logMethodAfterExecution(JoinPoint joinPoint) {

        // login what to do?
        logger.info("After Aspect - {} has executed", joinPoint);

    }

    // Do Something ONLY when a method throws an exception.
    @AfterThrowing(pointcut = "com.in28minutes.learnspringaop.aopexample.aspects.CommonPointcutConfig.allPackageConfigUsingBean()", throwing = "exception")
    public void logMethodAfterException(JoinPoint joinPoint, Exception exception) {

        // login what to do?
        logger.info("AfterThrowing Aspect - {} has thrown an exception {}", joinPoint, exception);

    }

    // Do Something ONLY when a method executes successfully
    @AfterReturning(pointcut ="com.in28minutes.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessPackageConfig()", returning = "resultValue")
    public void logMethodAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {

        // login what to do?
        logger.info("AfterReturning Aspect - {} has returned  {}", joinPoint, resultValue);

    }
}
