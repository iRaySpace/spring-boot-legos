package com.irayspace.learnratelimiter.ratelimiter;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RateLimiterService {

    private static final String PREFIX = "rate:ip:";
    private static final int MAX_REQUEST = 5;

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void validateRequest(String ipAddr) {
        final String key = PREFIX + ipAddr;

        final long requestCount = redisTemplate.opsForValue().increment(key);
        if (requestCount == 1) {
            redisTemplate.expire(key, Duration.ofMinutes(1));
        }

        if (requestCount > MAX_REQUEST) {
            throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS,
                    "Rate limit exceeded. Please try again later.");
        }
    }

}
