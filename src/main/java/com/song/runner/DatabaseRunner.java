package com.song.runner;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DatabaseRunner implements ApplicationRunner {
	@Autowired
	//spring-boot-starter-jdbc 의존성 등록시 자동으로 DataSource Bean등록
	DataSource dataSource;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.debug("DataSource Bean 구현체 "+ dataSource.getClass().getName());
		try (Connection connection = dataSource.getConnection()) {
			log.debug("url : {}",connection.getMetaData().getURL());
			log.debug("username : {}",connection.getMetaData().getUserName());
		}
	}
}
