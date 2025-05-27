package com.tanghai.projects;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
@MapperScan(basePackages = "com.tanghai.projects.**.repository")
public class ProjectsApplication {
//	@PostConstruct
//	public void run() {
//		ObjectTypeValidator objectTypeValidator = AnnotatedClass.class.getAnnotation(ObjectTypeValidator.class);
//
//		System.out.println("Object Type:::" + objectTypeValidator.objectType());
//
//	}
	public static void main(String[] args) {
		SpringApplication.run(ProjectsApplication.class, args);
	}

}
