package com.wyx.springbootredisdemo.config;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @author : Just wyx
 * @Date : 2020/11/20
 */
public class ByteRedisSerializer implements RedisSerializer<byte[]> {
	@Override
	public byte[] serialize(byte[] bytes) throws SerializationException {
		return bytes;
	}

	@Override
	public byte[] deserialize(byte[] bytes) throws SerializationException {
		return bytes;
	}
}
