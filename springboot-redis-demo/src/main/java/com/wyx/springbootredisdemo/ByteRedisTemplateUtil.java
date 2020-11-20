package com.wyx.springbootredisdemo;

import com.iiasaas.uc.entity.shiro.SupplierShiroUser;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author : Just wyx
 * @Date : 2020/11/20
 */
@Component
public class ByteRedisTemplateUtil {
	@Resource
	private RedisTemplate<String, byte[]> byteRedisTemplate;

	public String getSuppUserCache(String token){
		byte[] bytes = byteRedisTemplate.opsForValue().get("shiro:merchant:sys:" + token);
		return new String(bytes);
	}

	public SupplierShiroUser getSuppUserCache1(String token){
		SupplierShiroUser supplierShiroUser = null;
		try {
			byte[] bytes = byteRedisTemplate.opsForValue().get("shiro:merchant:sys:" + token);
			Session deserialize = (Session) deserialize(bytes);
			Object attribute = deserialize.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY");
			SimplePrincipalCollection s = (SimplePrincipalCollection)attribute;
			supplierShiroUser = s.oneByType(SupplierShiroUser.class);
		} catch (Exception e) {
			// TODO log
		}
		return supplierShiroUser;
	}

	/**
	 * (what) : 字节流转成对象信息
	 * (why) :
	 * (how) :
	 * @param bytes 入参
	 * @Author : Just wyx
	 * @Date : 14:20 2020/11/20
	 * @return : java.lang.Object
	 */
	private static Object deserialize(byte[] bytes) throws Exception {
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
