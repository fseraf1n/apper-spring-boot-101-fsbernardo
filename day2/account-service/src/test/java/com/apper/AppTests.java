package com.apper;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void givenUsingApache_whenGeneratingRandomAlphanumericString_thenCorrect() {
		String generatedString = RandomStringUtils.randomAlphanumeric(6);

		System.out.println(generatedString);
	}

}
