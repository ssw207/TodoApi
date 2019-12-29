package com.song.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class ListenerStartingEvent implements ApplicationListener<ApplicationStartingEvent> {

	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		// spring 컨테이너 생성전이므로 @Slf4j 사용불가 
		System.out.println("======================= Starting ======================");
	}

}
