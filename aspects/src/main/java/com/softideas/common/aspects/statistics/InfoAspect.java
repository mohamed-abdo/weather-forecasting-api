package com.softideas.common.aspects.statistics;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**+
 * Print method statistics,{threadId, className, methodName, timeInMs}
 */

@Aspect
@Component
public class InfoAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(InfoAspect.class);

    /**+
     * Print method statistics,{threadId, className, methodName, timeMs}
     * @param point
     * @return
     * @throws Throwable
     */

    @Around("execution(* *(..)) && @annotation(com.softideas.common.aspects.statistics.Info)")
    public Object aroundExecution(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = point.proceed();
        LOGGER.info("threadId={}, className={}, methodName={}, timeMs={}",
                Thread.currentThread().getId(),
                point.getSignature().getDeclaringTypeName(),
                ((MethodSignature) point.getSignature()).getMethod().getName(),
                System.currentTimeMillis() - start
        );
        return result;
    }
}

