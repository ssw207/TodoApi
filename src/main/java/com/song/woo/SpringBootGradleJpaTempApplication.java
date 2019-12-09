package com.song.woo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringBootGradleJpaTempApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGradleJpaTempApplication.class, args);
		System.out.println("START");
	}
}
