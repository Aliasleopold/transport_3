package com.transport.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import com.transport.service.BusTripServiceImpl;

@Aspect
public class BenchMarkAspect {

    /** Logger. */
    private static final Logger LOG = LoggerFactory
            .getLogger(BusTripServiceImpl.class);

    /**
     * Definition of pointcut.
     */
    @Pointcut("execution(* com.transport.service.*ServiceImpl.*(..))")
    public void bench() {
    }

    /**
     * Around.
     * @param jp
     *            - join point
     * @return the returned object method.
     * @throws Throwable
     *             - error
     */
    @Around("bench()")
    public final Object advice(final ProceedingJoinPoint jp) throws Throwable {
        final StopWatch sw = new StopWatch(jp.toShortString());
        try {
            sw.start();
            return jp.proceed();
        } finally {
            sw.stop();
            if (jp.getSignature() instanceof MethodSignature) {
                LOG.debug("{} : {} ms", ((MethodSignature) jp.getSignature())
                    .getMethod().toGenericString(), sw.getTotalTimeMillis());
            }
        }
    }
}
