package com.codingdojo.firstproject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
//@RequestMapping("/coding")
public class CodingController {
	@RequestMapping("/coding")
	public String hello() {
		return "Hello Coding Dojo!";
	}
	@RequestMapping("/coding/python")
	public String python() {
		return "Python/Django was awesome!";
	}
	@RequestMapping("/coding/java")
	public String java() {
		return "Java/Spring is better!";
	}
	@RequestMapping("/dojo/{location}")
	public String local(@PathVariable("location") String location) {
		//System.out.println(location);
		if(location == "san-jose") {
			return "SJ dojo is the headquarters";
		}
		return location;
	}
	@RequestMapping("/greet")
	public String greeting(@RequestParam(value = "firstName", required = false) String firstName, @RequestParam(value="lastName", required=false) String lastName) {
		if(firstName == null || lastName == null) {
			return "<h1>hello huamn!</h1><p>Welcome to Java Spring!</p>";
		}else {
			return "<h1>hello " + firstName + "-" + lastName + "!</h1>" + "<p>Welcome to Java Spring!</p>";
		}
	}
}
