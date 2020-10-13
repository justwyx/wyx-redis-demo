package jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @Description : 通过jedis直连
 * @author : Just wyx
 * @Date : 2020/8/22
 */
public class TestJedis {

	@Test
	public void testJedis() {
		// 创建连接
		Jedis jedis = new Jedis("127.0.0.1", 6379);

		String key = "myTest";
		// 删除key
		System.out.println(jedis.del(key));
		// 第一次获取对应key的value
		System.out.println(key + ":" +jedis.get(key));
		// set key value
		jedis.set(key, "hello world1");
		// 第二次获取对应key的value
		System.out.println(key + ":" +jedis.get(key));
		// 关闭连接
		jedis.close();
	}
}
