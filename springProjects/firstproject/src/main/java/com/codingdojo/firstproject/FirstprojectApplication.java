package com.codingdojo.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//2. Importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//1. Annotation
@RestController
public class FirstprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstprojectApplication.class, args);
	}
	// 1. Annotation
    @RequestMapping("/")
    // 3. Method that maps to the request route above
    public String hello() {
    	return "Hello Client! How are you doing?";
    }
    @RequestMapping("/random")
    public String greeting() {
    	return "Spring Boot is great! So easy with response with string.";
    }
}
