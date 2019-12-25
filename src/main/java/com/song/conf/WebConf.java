package com.song.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConf implements WebMvcConfigurer {
	// CORS 설정 참고 : https://heowc.dev/2018/03/13/spring-boot-cors/
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("http://127.0.0.1:8080") // 이 경로에서 접근하는경우 허용
		.allowedOrigins("http://localhost:8080")
        .allowedMethods( // 선언한 매서드들로 접근 허용
        		HttpMethod.POST.name(), 
        		HttpMethod.DELETE.name(),
        		HttpMethod.PUT.name(),
        		HttpMethod.GET.name());
	}
}
