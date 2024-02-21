package com.project.security.rateLimiter;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class RedisRateLimiter {


    private final RedisTemplate<String, String> redisTemplate;
    private final static int MAX_REQUESTS_PER_HOUR = 3;

    public boolean isLimitExceeded(String email) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String key = "rate_limit:" + email;
        String currentRequests = valueOperations.get(key);

        if (currentRequests == null) {
            valueOperations.set(key, "1", Duration.ofSeconds(60));
            return false;
        }

        int requests = Integer.parseInt(currentRequests);
        if (requests >= MAX_REQUESTS_PER_HOUR) {
            return true;
        }

        valueOperations.increment(key);
        return false;
    }
}
