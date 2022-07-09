package com.codingdojo.firstproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
@RequestMapping("/greeting")
public class HomeController {
	@RequestMapping("")
    public String index(@RequestParam(value = "q", required = false) String searchQuery){
		if(searchQuery == null) {
			return "Greeting! This is searching for nothing.";
		}else {
			return "Greeting! This is seraching for " + searchQuery;
		}
    }
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
      return "Hello world! What route did you use to access me?";
    }
    @RequestMapping("/m/{track}/{module}/{lesson}")
    public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson) {
    	return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
    }
    @RequestMapping("/goodbye")
    public String world(){
      return "Goodbye world!";
    }
}
