package com.pad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.core.*","com.pad.*","com.business.*"})
public class SystemRunApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemRunApplication.class, args);
	}

}
