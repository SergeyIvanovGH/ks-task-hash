package com.sivanov.kstaskhash.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@ComponentScan("com.sivanov.kstaskhash.controllers")
public class SwaggerConfig {


	@Bean
	public Docket phase1ApiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Task hash")
				.apiInfo(apiPhase1Info())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(regex("/data.*"))
				.build()
				.securitySchemes(Collections.singletonList(new BasicAuth("basicAuth")));
	}

	private ApiInfo apiPhase1Info() {
		return new ApiInfoBuilder()
				.title("Task hash")
				.description("")
				.version("2.0")
				.build();
	}
}
