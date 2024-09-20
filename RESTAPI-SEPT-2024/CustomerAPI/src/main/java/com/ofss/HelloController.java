package com.ofss;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	// API NO: 1
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		return "Hello Spring Boot Application";
	}

	// API NO: 2
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "Welcome to the world of RESTFUL apis";
	}

	// API NO: 3
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String sayHello1() {
		return "Hello this is post method";
	}

}
