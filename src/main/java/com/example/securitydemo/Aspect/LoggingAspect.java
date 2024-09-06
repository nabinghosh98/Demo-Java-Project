package com.example.securitydemo.Aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class LoggingAspect {


    @Pointcut(value = "expression(* com.example.securitydemo.StringExamples.*.*(..))")
    public void myPointCut(){

    }

    @Around("myPointCut()")
    public Object applicationLogging(ProceedingJoinPoint pjp) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
         String methodName = pjp.getSignature().getName();
         String className = pjp.getTarget().getClass().toString();
         Object[] array = pjp.getArgs();

        System.out.println(mapper.writeValueAsString(array));

        Object object = pjp.proceed();
        System.out.println(mapper.writeValueAsString(object));
        return object;
    }

}
