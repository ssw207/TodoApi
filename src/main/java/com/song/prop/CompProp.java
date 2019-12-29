package com.song.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties("comp") // application.properties파일에 정의된 comp.name=이름 ... 값들이 세팅된다.
@Getter @Setter
public class CompProp {
	private String name;
	private String hp;
	private String addr;
}
