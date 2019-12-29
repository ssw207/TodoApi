package com.song.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.song.prop.CompProp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PropRunner implements ApplicationRunner {
	
	@Autowired
	private String initMsg;
	
	@Autowired
	private CompProp compProp;
	
	@Value("${profile.name}")
	private String activeProfile;
	
	@Value("${server.port}")
	private String port;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.debug("현재 설정 : {}",initMsg);
		log.debug("현재 profile : {}", activeProfile);
		log.debug("현재 port : {}", port);
		log.debug("==============업체 정보===============");
		log.debug("업체명 : {}",compProp.getName());
		log.debug("업체 전화번호 : {}",compProp.getHp());
		log.debug("업체 주소 : {}",compProp.getAddr());
	}
	
}
