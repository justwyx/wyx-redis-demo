package com.wyx.springbootredisdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : Just wyx
 * @Date : 2020/11/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ByteRedisTemplateTest {
	@Autowired
	private ByteRedisTemplateUtil byteRedisTemplateUtil;

	@Test
	public void test() {
		System.out.println(byteRedisTemplateUtil.getSuppUserCache("nanjingsaas.cn:1f70a583-1d8b-4ca1-a7c5-b6935b7e238c"));
	}

	@Test
	public void test1() {
		System.out.println(byteRedisTemplateUtil.getSuppUserCache1("nanjingsaas.cn:1f70a583-1d8b-4ca1-a7c5-b6935b7e238c"));
	}
}
