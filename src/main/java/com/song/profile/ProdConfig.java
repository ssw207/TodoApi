package com.song.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class ProdConfig {
	// application.yml에서 profile을 prod로 설정하면 아래의 Bean이 등록된다.
	@Bean
	public String initMsg() {
		return "운영 환경(prod)";
	}
}
