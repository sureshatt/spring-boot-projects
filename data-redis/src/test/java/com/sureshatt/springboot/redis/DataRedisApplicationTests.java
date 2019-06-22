package com.sureshatt.springboot.redis;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataRedisApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	public void contextLoads() {
		assertThat(context, Matchers.notNullValue());
	}

}
