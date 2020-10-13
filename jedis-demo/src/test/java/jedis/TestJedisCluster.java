package jedis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description : 通过jedisPool直连
 * @author : Just wyx
 * @Date : 2020/8/22
 */
public class TestJedisCluster {
	private JedisCluster jedisCluster;

	@Before
	public void initJedisCluster() {
		System.out.println("init jedisCluster...");
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("127.0.0.1", 7001));
		nodes.add(new HostAndPort("127.0.0.1", 7002));
		nodes.add(new HostAndPort("127.0.0.1", 7003));
		jedisCluster = new JedisCluster(nodes);
	}

	@Test
	public void testJedisCluster() {
		String key = "myTest3";
		// 删除key
		System.out.println(jedisCluster.del(key));
		// 第一次获取对应key的value
		System.out.println(key + ":" + jedisCluster.get(key));
		// set key value
		jedisCluster.set(key, "hello world");
		// 第二次获取对应key的value
		System.out.println(key + ":" + jedisCluster.get(key));
		// 关闭连接
		jedisCluster.close();
	}

	@Test
	public void getKey() {
		String key = "myTest3";
		System.out.println(key + ":" + jedisCluster.get(key));
	}

	@After
	public void close() {
		System.out.println("close jedisCluster...");
		jedisCluster.close();
	}
}
