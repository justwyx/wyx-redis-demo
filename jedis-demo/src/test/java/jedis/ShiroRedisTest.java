package jedis;

import com.alibaba.fastjson.JSONArray;
import com.iiasaas.uc.entity.shiro.SupplierShiroUser;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.junit.Test;
import redis.clients.jedis.BinaryJedis;
import redis.clients.jedis.Jedis;

import java.io.*;

/**
 * @author : Just wyx
 * @Date : 2020/11/20
 */
public class ShiroRedisTest {


	@Test
	public void doCreate() throws Exception {
		// 创建连接
		BinaryJedis binaryJedis = new BinaryJedis("192.168.1.13", 7003);
		Person person = new Person("文宇祥", 26);

		String key = "shiro:merchant:sys:doCreateTest";

		String set = binaryJedis.set(key.getBytes(), serialize(person));
		System.out.println(set);


		// 关闭连接
		binaryJedis.close();
	}

	@Test
	public void doCreate1() throws Exception {
		// 创建连接
		Jedis binaryJedis = new Jedis("192.168.1.13", 7003);
		Person person = new Person("文宇祥", 26);

		String key = "shiro:merchant:sys:doCreateTest";

		String set = binaryJedis.set(key, JSONArray.toJSON(person).toString());
		System.out.println(set);

		// 关闭连接
		binaryJedis.close();
	}
	@Test
	public void doReadSession() throws Exception {
		// 创建连接
		Jedis binaryJedis = new Jedis("192.168.1.13", 7003);

//		String key = "shiro:merchant:sys:doCreateTest";
		String key = "shiro:merchant:sys:nanjingsaas.cn:1f70a583-1d8b-4ca1-a7c5-b6935b7e238c";

		byte[] bytes = binaryJedis.get(key.getBytes());
		Session deserialize = (Session) deserialize(bytes);
//		Object deserialize = deserialize(bytes);


		Object attribute = deserialize.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY");
		SimplePrincipalCollection s = (SimplePrincipalCollection)attribute;
		SupplierShiroUser supplierShiroUser = s.oneByType(SupplierShiroUser.class);
		System.out.println(supplierShiroUser);
		// 关闭连接
		binaryJedis.close();
	}

	@Test
	public void doReadSession1() {
		// 创建连接
		Jedis binaryJedis = new Jedis("192.168.1.13", 7003);

		String key = "shiro:merchant:sys:doCreateTest";

		String value = binaryJedis.get(key);
		Person person = JSONArray.parseObject(value, Person.class);
		System.out.println(person);

		// 关闭连接
		binaryJedis.close();
	}

	public static byte[] serialize(Object object) throws Exception {
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
			e.printStackTrace();
			throw new Exception("deserialize error", e);
		}

		return result;
	}
}
