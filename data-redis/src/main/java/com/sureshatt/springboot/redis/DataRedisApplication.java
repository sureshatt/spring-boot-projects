package com.sureshatt.springboot.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class DataRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataRedisApplication.class, args);
	}

	@Bean(name = "RedisDataTemplate")
	RedisTemplate<String, RedisData> createRedisDataTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, RedisData> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}

	@Bean(name = "RedisIpTemplate")
	RedisTemplate<String, String> createRedisIpTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, String> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}
}
