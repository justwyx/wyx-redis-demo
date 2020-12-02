package com.wyx.springbootredisdemo;

import com.wyx.springbootredisdemo.config.ByteRedisSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
public class SpringbootRedisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRedisDemoApplication.class, args);
	}

	@Bean("byteRedisTemplate")
	public RedisTemplate<String, byte[]> byteRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, byte[]> redisTemplate = new RedisTemplate<>();
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new ByteRedisSerializer());
		redisTemplate.setValueSerializer(new ByteRedisSerializer());
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		return redisTemplate;
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, String> redis = new RedisTemplate<>();
		redis.setConnectionFactory(redisConnectionFactory);

		// 设置redis的String/Value的默认序列化方式
		redis.setKeySerializer(new StringRedisSerializer());
		redis.setValueSerializer(new StringRedisSerializer());
		redis.setHashKeySerializer(new StringRedisSerializer());
		redis.setHashValueSerializer(new StringRedisSerializer());

		redis.afterPropertiesSet();
		return redis;
	}
}
