package com.aaronzadev.restapiexample;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestApiApplication {

	private static final String APP_NAME = "Rest Api and Swagger Example";
	private static final String APP_DESCRIPTION ="A rest api example made with spring boot and swagger";
	private static final String APP_VERSION="1.0";

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	@Bean
	public OpenAPI openApiOptions() {
		return new OpenAPI()
				.info(new Info()
						.title(APP_NAME)
						.description(APP_DESCRIPTION)
						.version(APP_VERSION)
						.license(new License()
								.name("Apache 2.0")
								.url("http://springdoc.org")));
				/*.externalDocs(new ExternalDocumentation()
						.description("SpringShop Wiki Documentation")
						.url("https://springshop.wiki.github.org/docs"));*/
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
