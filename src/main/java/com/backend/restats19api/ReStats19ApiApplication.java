package com.backend.restats19api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class ReStats19ApiApplication {
	@GetMapping
	public String Hello(){
		return "-- Hello the world !! --";
	}

	public static void main(String[] args) {
		SpringApplication.run(ReStats19ApiApplication.class, args);
	}

}
