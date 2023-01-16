package com.rest.practice.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloWorldController {

	@GetMapping(path="hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	
}
