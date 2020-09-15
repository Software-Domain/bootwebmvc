package com.ray.bootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.ray.bootweb.controller", "com.ray.bootweb.service"})
public class BootwebmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootwebmvcApplication.class, args);
	}

}
