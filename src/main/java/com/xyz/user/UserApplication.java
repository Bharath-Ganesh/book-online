package com.xyz.user;

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
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);

	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.xyz.user"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	private static ApiInfo apiInfo() {
		return new ApiInfo("User Microservice",
				"User Microservice is a basic application which would let the user to login or register to the Parcel delivery system. Following"
						+ "are the api's which are part of the user microservice " + "1. User login\r\n"
						+ "2. User Signup\r\n" + "3. Add Address\r\n",
				"", null, null, null, null, Collections.emptyList());
	}

}
