package com.song.woo.member.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.song.woo.member.model.Member;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceTest {
	
	@Autowired
	MemberService service;
	
	@Test
	public void 아이디_중복체크_테스트() {
		//before
		Member dto = service.memberSave(Member.builder().memId("test123").memPw("1234").memName("test").build());
		
		//after
		boolean isDuplicate = service.isDuplicateId(dto.getMemId());
		
		assertTrue(isDuplicate);
		
	}
}
