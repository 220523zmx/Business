package com.datangedu.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemoAbcApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DemoAbcApplication.class, args);
	}
	public SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DemoAbcApplication.class);
	}

}
