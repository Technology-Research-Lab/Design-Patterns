package spring.designpatterns.dom.proxy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerfAspect {

    @Around("bean(gameService)")
    public void timestamp(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        point.proceed();
        System.out.println("걸린 시간 : " + (System.currentTimeMillis() - start));
    }
}
