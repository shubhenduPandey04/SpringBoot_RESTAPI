package com.ofss;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HelloSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootApplication.class, args);
		System.out.println("Customer API With Swagger Documentation Started!");
	}

	@Bean
	public Docket swaggerConfiguration()
	{
		Docket d=new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/**")) // this is for all URIs and SUB-URIs"
				.apis(RequestHandlerSelectors.basePackage("com.ofss"))
				.build()
				.apiInfo(apiDetails());
		return d;
	}

	private ApiInfo apiDetails() 
	{
		return new ApiInfo("Customer REST API", 
							"CRUD OPERATIONS CUSTOMER", 
							"1.0", 
							"Free API",
							new springfox.documentation.service.Contact("Shubhendu", "Shubhendu.com", "shubhendupandey28@gmail.com"), 
							"API License", 
							"http://wwww.shubhendu.com",
							Collections.emptyList());
	}
}
