package com.irayspace.learnratelimiter.ratelimiter;

import java.util.Optional;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class RateLimiterAspect {

    @Autowired
    private RateLimiterService rateLimiterService;

    @Around("@annotation(rateLimiter)")
    public Object around(ProceedingJoinPoint pjp, RateLimiter rateLimiter) throws Throwable {
        final Optional<HttpServletRequest> request = getCurrentRequest();
        if (!request.isEmpty()) {
            rateLimiterService.validateRequest(request.get().getRemoteAddr());
        }
        return pjp.proceed();
    }

    private Optional<HttpServletRequest> getCurrentRequest() {
        final RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            return Optional.of(((ServletRequestAttributes) requestAttributes).getRequest());
        }
        return Optional.empty();
    }

}
