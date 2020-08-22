package com.wyx.jedis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description : 通过jedisPool直连
 * @author : Just wyx
 * @Date : 2020/8/22
 */
public class TestJedisCluster {
	private JedisCluster jedis;

	@Before
	public void initJedisCluster() {
		System.out.println("init jedisCluster...");
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.1.55", 7001));
		nodes.add(new HostAndPort("192.168.1.55", 7002));
		nodes.add(new HostAndPort("192.168.1.55", 7003));
		jedis = new JedisCluster(nodes);

	}

	@Test
	public void testJedisCluster() {

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

	@After
	public void close() {
		System.out.println("close jedisCluster...");
		jedis.close();
	}
}
