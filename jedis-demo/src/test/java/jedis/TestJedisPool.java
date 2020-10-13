package jedis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Description : 通过jedisPool直连
 * @author : Just wyx
 * @Date : 2020/8/22
 */
public class TestJedisPool {
	private JedisPool jedisPool;

	@Before
	public void initJedisPool() {
		System.out.println("init jedisPool...");
		this.jedisPool = new JedisPool("127.0.0.1", 6379);
	}

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
		jedis.set(key, "hello world");
		// 第二次获取对应key的value
		System.out.println(key + ":" +jedis.get(key));
		// 关闭连接
		jedis.close();
	}

	@After
	public void close() {
		System.out.println("close jedisPool...");
		jedisPool.close();
	}
}
