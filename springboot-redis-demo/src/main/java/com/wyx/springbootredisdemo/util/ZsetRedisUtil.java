package com.wyx.springbootredisdemo.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author : Just wyx
 * @Date : 2020/12/1
 */
@Component
public class ZsetRedisUtil {
	@Resource
	private RedisTemplate redisTemplate;

	public boolean add(String key, String value, double score) {
		if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
			return false;
		}
		return redisTemplate.opsForZSet().add(key, value, score);
	}

	public boolean add(String key, Integer value, double score) {
		return add(key, String.valueOf(value), score);
	}

	public long remove(String key, String value) {
		return redisTemplate.opsForZSet().remove(key, value);
	}
	public long remove(String key, Integer value) {
		return this.remove(key, String.valueOf(value));
	}


	public String getOne(String key) {
		Set<String> range = redisTemplate.opsForZSet().range(key, 0, 1);
		if (range == null || range.size() <= 0) {
			return null;
		}
		String value = range.iterator().next();
		return value;
	}

	/**
	 * (what) : 获取指定分数区间内第一条记录(分数最小)
	 * (why) :
	 * (how) :
	 * @param key key
	 * @param score 入参
	 * @Author : Just wyx
	 * @Date : 14:50 2020/12/1
	 * @return : java.lang.String
	 */
	public String getOneByScore(String key, long score) {
		Set<String> range = redisTemplate.opsForZSet().rangeByScore(key, 0, score, 0, 1);
		if (range == null || range.size() <= 0) {
			return null;
		}
		String value = range.iterator().next();
		return value;
	}
}
