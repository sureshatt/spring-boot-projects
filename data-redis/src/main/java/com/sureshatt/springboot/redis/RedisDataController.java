package com.sureshatt.springboot.redis;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RedisDataController {


    private final RedisTemplate<String, RedisData> redisDataRedisTemplate;
    private final RedisTemplate<String, String> redisIpTemplate;

    public RedisDataController(@Qualifier("RedisDataTemplate") RedisTemplate<String, RedisData> redisDataRedisTemplate, @Qualifier("RedisIpTemplate") RedisTemplate<String, String> redisIpTemplate) {
        this.redisDataRedisTemplate = redisDataRedisTemplate;
        this.redisIpTemplate = redisIpTemplate;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/redis-value", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RedisData> storeRandomData() {
        RedisData data = new RedisData("123", "/this-is-data", 2);
        ValueOperations<String, RedisData> opsForValue = redisDataRedisTemplate.opsForValue();
        opsForValue.set("ciam:captcha:ip", data);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ip", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Long> storeIpData(HttpServletRequest httpServletRequest) {
        String key = httpServletRequest.getRemoteHost() + ":" + httpServletRequest.getRequestURI();

        ValueOperations<String, String> opsForValue = redisIpTemplate.opsForValue();
        Long incremented = opsForValue.increment(key);
        redisIpTemplate.opsForHash().put("CAPTCHA", "10.10.10.10/register", 0);
        return new ResponseEntity<>(incremented, HttpStatus.CREATED);
    }

}
