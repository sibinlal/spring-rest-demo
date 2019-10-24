package com.test.springrest.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemorestController {
	
	@GetMapping("/hello")
	public String sayhello() {
		return "Hello World!!";
	}

}
