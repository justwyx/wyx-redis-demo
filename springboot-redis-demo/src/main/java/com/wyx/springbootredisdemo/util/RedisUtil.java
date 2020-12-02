package com.wyx.springbootredisdemo.util;

import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author : Just wyx
 * @Description : TODO 2020/8/6
 * @Date : 2020/8/6
 */
@Component
public class RedisUtil {
	public final static long ONE_HOUR_TIME = 60 * 60 * 1000;

	@Resource
	private StringRedisTemplate stringRedisTemplate;


	public String get(String key) {
		return key == null ? null : stringRedisTemplate.opsForValue().get(key);
	}

	public boolean set(String key, String value) {
		try {
			stringRedisTemplate.opsForValue().set(key, value);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * 带超时时间的缓存值，单位: s
	 *
	 * @param key
	 * @param value
	 * @param time
	 * @return
	 */
	public boolean set(String key, String value, long time) {
		try {
			if (time > 0) {
				stringRedisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
			} else {
				set(key, value);
			}
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	public boolean del(String key) {
		try {
			return stringRedisTemplate.delete(key);
		} catch (Exception e) {
		}
		return false;
	}


	public Set<String> keys(String keyPrefix) {
		String realKey = keyPrefix + "*";

		try {
			return stringRedisTemplate.execute((RedisCallback<Set<String>>) connection -> {
				Set<String> binaryKeys = new HashSet<>();
				Cursor<byte[]> cursor = connection.scan(new ScanOptions.ScanOptionsBuilder().match(realKey).count(Integer.MAX_VALUE).build());
				while (cursor.hasNext()) {
					binaryKeys.add(new String(cursor.next()));
				}

				return binaryKeys;
			});
		} catch (Throwable e) {
		}

		return null;
	}

	/**
	 *  删除指定前缀的一系列key
	 * @param keyPrefix
	 */
	public void removeAll(String keyPrefix) {
		try {
			Set<String> keys = keys(keyPrefix);
			Long deleteNum = stringRedisTemplate.delete(keys);
			System.out.println("deleteNum:" + deleteNum);
		} catch (Throwable e) {
		}
	}

}