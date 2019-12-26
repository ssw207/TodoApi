package com.song.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration  // 설정을 위한 bean등록
@EnableSwagger2 // Swagger2 사용을 위해 선언
public class SwaggerConfig {
	
	// localhost:8080/swagger-ui.html 에서 조회가능 
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2) // Swagger2의 문서 설정을함
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.song.woo.api")) // 지정된 패키지의 모든 url리스트를 추출
				.build();
				//.apis(RequestHandlerSelectors.any()) // 현재 RequestMapping으로 할당된 모든 URl리스트를 추출
				//.paths(PathSelectors.ant("/api/**")) // 그중 /api/** 인 URL들만 필더링
	}

}
