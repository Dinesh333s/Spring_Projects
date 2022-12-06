package com.floppy.Hello.world;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HelloWorldController {

	@GetMapping("/helloworld")
	public String Hello()
	{
		return "Hello";
	}
}
