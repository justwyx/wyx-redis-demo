package jedis;

import org.junit.Test;
import redis.clients.jedis.BinaryJedis;
import redis.clients.jedis.Jedis;

import java.io.*;

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

	@Test
	public void test1() throws IOException, ClassNotFoundException {
		// 创建连接
		BinaryJedis binaryJedis = new BinaryJedis("192.168.1.13", 7003);

		String key = "shiro:merchant:sys:nanjingsaas.cn:b6d39748-0bca-46d1-99f4-fa9d0d707c35";
		// 第一次获取对应key的value
		byte[] bytes = binaryJedis.get(key.getBytes());

		Object deserialize;
		try {
			deserialize = deserialize(bytes);

			System.out.println(key + ":" + deserialize);
		} catch (Exception e) {
			e.printStackTrace();
		}



		// 关闭连接
		binaryJedis.close();
	}

	public byte[] serialize(Object object) throws Exception {
		byte[] result = new byte[0];

		if (object == null) {
			return result;
		}
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream(128);
		if (!(object instanceof Serializable)) {
			throw new Exception("requires a Serializable payload "
					+ "but received an object of type [" + object.getClass().getName() + "]");
		}
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteStream);
			objectOutputStream.writeObject(object);
			objectOutputStream.flush();
			result =  byteStream.toByteArray();
		} catch (IOException e) {
			throw new Exception("serialize error, object=" + object, e);
		}

		return result;
	}

	public static Object deserialize(byte[] bytes) throws Exception {
		Object result = null;

		if (bytes == null || bytes.length == 0) {
			return result;
		}

		try {
			ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
			ObjectInputStream objectInputStream = new ObjectInputStream(byteStream);
			result = objectInputStream.readObject();
		} catch (IOException e) {
			throw new Exception("deserialize error", e);
		} catch (ClassNotFoundException e) {
			throw new Exception("deserialize error", e);
		}

		return result;
	}
}
