package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MultiYmlDemoApplicationTests {

	@Value("${myenvironment.name}")
	private String name;
	@Test
	public void getMyEnvironment(){
		System.out.println(name);
	}

}
