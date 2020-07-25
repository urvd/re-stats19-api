package com.backend.restats19api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

@SpringBootApplication
@RestController
public class ReStats19ApiApplication {

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String Hello(){
		return "-- Hello the world !! --";
	}

	public static void main(String[] args) {
		SpringApplication.run(ReStats19ApiApplication.class, args);
	}

}
