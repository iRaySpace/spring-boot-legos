package com.irayspace.observability.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import brave.Tracer;
import brave.Tracing;


@Aspect
@Component
public class ScopedSpanAspect {
    
    @Around("@annotation(ScopedSpan)")
    public Object scopedSpan(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        ScopedSpan scopedSpanAnnotation = signature.getMethod().getAnnotation(ScopedSpan.class);
        brave.ScopedSpan scopedSpan = Tracing.currentTracer().startScopedSpan(scopedSpanAnnotation.value());
        Object res = joinPoint.proceed();
        scopedSpan.finish();
        return res;
    }

}
