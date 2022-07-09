package com.codingdojo.mvc;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.codingdojo.mvc.controllers.BooksController;

@SpringBootTest
class MvcApplicationTests {
	@Autowired
    // use the name of the controller you create in your project
    private BooksController controller;
	
	@Test
	void contextLoads() {
	}
	
	@Test
    void testController() {
        assertThat(controller).isNotNull();
    }
}
