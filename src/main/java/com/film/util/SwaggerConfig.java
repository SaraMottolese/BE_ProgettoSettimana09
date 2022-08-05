package com.film.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Api(value="BE_ProgettoSettimana09", tags="Progetto settimana 09 lista film")
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
		        .select()
		        .apis(RequestHandlerSelectors.any())
		        .build()
		        .apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() 
	{
		return new ApiInfoBuilder()
				.title("BE_ProgettoSettimana09")
                .description("Progetto settimana 09 lista film")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Mio Nome", "http://mySite.it", "me@mydummyemail.it"))
                .build();
	}
}
