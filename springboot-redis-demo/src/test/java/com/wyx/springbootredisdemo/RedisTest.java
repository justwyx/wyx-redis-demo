package com.wyx.springbootredisdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : Just wyx
 * @Description : TODO 2020/10/10
 * @Date : 2020/10/10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
	@Autowired
	private RedisUtil redisUtil;

	@Test
	public void removeKeys() {
		redisUtil.removeAll("shiro");
	}
}
