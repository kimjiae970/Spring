package com.example.springwebbasic.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Aspect : 해당 클래스가 부가 관심사 클래스 임을 알려주는 어노테이션
 * 자동으로 빈으로 등록되지 않으므로 따로 Component 혹은 config에 등록해주어야 함
 */
@Aspect
@Component
public class TimeTraceAop {

    //@Around : 핵심 관심사의 실패여부와 상관없이 전후로 실행되도록 하는 advice
    @Around("execution(* com.example.springwebbasic..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        System.out.println("START "+ joinPoint.toString());

        try {
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END "+ joinPoint.toString() +" " +timeMs + "ms");
        }
    }
}
