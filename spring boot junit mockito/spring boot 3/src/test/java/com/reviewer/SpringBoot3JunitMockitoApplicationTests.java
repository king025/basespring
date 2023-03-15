package com.reviewer;

import com.reviewer.controllers.ProductController;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBoot3JunitMockitoApplicationTests {

	@Autowired
	ProductController productController;

	@Test
	public void contextLoads() {
		Assertions.assertThat(productController).isNotNull();
	}

}
