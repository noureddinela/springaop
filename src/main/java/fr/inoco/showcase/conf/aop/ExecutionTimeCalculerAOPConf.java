package fr.inoco.showcase.conf.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@ConditionalOnExpression("${showstat.enabled:true}")
public class ExecutionTimeCalculerAOPConf {

    @Around("@annotation(fr.inoco.showcase.conf.aop.annotation.CalculateExecutionTime)")
    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        log.info(
                "{} executed in {}ms",
                joinPoint.getSignature(),
                executionTime
        );

        return result;
    }
}