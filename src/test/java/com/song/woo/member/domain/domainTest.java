package com.song.woo.member.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.song.woo.member.model.Member;
import com.song.woo.member.repository.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class domainTest {
	@Autowired
	MemberRepository memberDao;
	
	@Test
	public void 저장_단일조회_테스트(){
		//given
		Member dto= memberDao.save(Member.builder().memId("admin").memPw("1234").memName("name").build());
		
		//when
		Member memberInfo = memberDao.findByMemId(dto.getMemId());
		
		//then
		assertThat( memberInfo.getMemId() , is("admin") );
	}
}
