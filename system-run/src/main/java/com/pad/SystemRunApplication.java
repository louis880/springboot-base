package com.pad;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(scanBasePackages={"com.core.*","com.pad.*","com.business.*"})
//@MapperScan("com.pad.ant.mybatis.mapper")
public class SystemRunApplication {
	public static void main(String[] args) {
		SpringApplication.run(SystemRunApplication.class, args);
	}
}
