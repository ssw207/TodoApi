package com.song.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class TestConfig {
	// application.yml에서 profile을 test로 설정하면 아래의 Bean이 등록된다.
	@Bean
	public String initMsg() {
		return "테스트 환경(test)";
	}
}
