package com.sun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

//mapper 接口类扫描包配置
@MapperScan("com.sun.dao")
@ImportResource(locations={"classpath:applicationContext.xml"})
@SpringBootApplication
public class SpringbootStarter extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		builder.sources(this.getClass());
		return super.configure(builder);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStarter.class, args);
	}
}