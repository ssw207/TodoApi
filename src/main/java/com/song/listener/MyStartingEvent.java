package com.song.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class MyStartingEvent implements ApplicationListener<ApplicationStartingEvent> {
	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		System.out.println("ApplicationStarting Evnet 발생함");
	}
}
