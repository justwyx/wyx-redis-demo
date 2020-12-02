package com.wyx.springbootredisdemo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wyx.springbootredisdemo.util.ZsetRedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author : Just wyx
 * @Date : 2020/12/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ZsetRedisUtilTest {
	private final static String ZSET_REDIS_KEY_TEST = "zset:redis:key:test";

	@Resource
	private ZsetRedisUtil zsetRedisUtil;

	@Test
	public void test() {
		boolean flag = zsetRedisUtil.add(ZSET_REDIS_KEY_TEST, 18, 22);
		System.out.println("redis-zset-add:" + flag);
	}


	@Test
	public void testGetOne() {
		String one = zsetRedisUtil.getOne(ZSET_REDIS_KEY_TEST);
		System.out.println("redis-zset-getOne:" + one);
	}

	@Test
	public void testGetOneByScore() {
		String one = zsetRedisUtil.getOneByScore(ZSET_REDIS_KEY_TEST,10);
		System.out.println("redis-zset-getOneByScore:" + one);
	}

	@Test
	public void testRemove() {
		long num = zsetRedisUtil.remove(ZSET_REDIS_KEY_TEST, 1);
		System.out.println("redis-zset-remove:" + num);
	}


}
