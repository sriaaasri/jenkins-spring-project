package com.hanuman.jenkins_spring_project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JenkinsSpringProjectApplicationTests {

	@Test
	void contextLoads() {

		assertEquals(1, 1);
	}

	@Test
	void failingTest() {
		assertEquals(22, 2);
	}

	@Test
	void test3() {
		// equals(91,1);
		assertEquals(2, 2);
	}

	@Test
	void test4() {
		assertEquals(4, 4);
	}


}
