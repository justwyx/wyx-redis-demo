package com.wyx.jedis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

/**
 * @Description : spring-jedis整合测试类
 * @author : Just wyx
 * @Date : 2020/8/22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class testJedis {
	@Resource
	private JedisPool jedisPool;

	@Resource
	private JedisCluster jedisCluster;

	@Test
	public void testJedisPoll() {
		// 从连接池中获得连接
		Jedis jedis = jedisPool.getResource();

		String key = "myTest";
		// 删除key
		System.out.println(jedis.del(key));
		// 第一次获取对应key的value
		System.out.println(key + ":" +jedis.get(key));
		// set key value
		jedis.set("myTest", "hello world");
		// 第二次获取对应key的value
		System.out.println(key + ":" +jedis.get(key));
		// 关闭连接
		jedis.close();
	}


	@Test
	public void testJedisCluster() {
		String key = "myTest";
		// 删除key
		System.out.println(jedisCluster.del(key));
		// 第一次获取对应key的value
		System.out.println(key + ":" + jedisCluster.get(key));
		// set key value
		jedisCluster.set("myTest", "hello world");
		// 第二次获取对应key的value
		System.out.println(key + ":" + jedisCluster.get(key));
		// 关闭连接
		jedisCluster.close();
	}
}
