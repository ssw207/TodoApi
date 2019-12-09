package com.song.woo.member.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.assertj.core.api.AssertFactory;
import org.hamcrest.Matcher;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.song.woo.member.dao.MemberDao;
import com.song.woo.member.model.Member;

@RunWith(SpringRunner.class)
@SpringBootTest
public class domainTest {
	@Autowired
	MemberDao memberDao;
	
	@Test
	public void 저장_단일조회_테스트(){
		//given
		Member member = new Member();
		member.setMemId("admin");
		
		memberDao.save(member);
		
		//when
		Member memberInfo = memberDao.findAll().get(0);
		
		//then
		assertThat( memberInfo.getMemId() , is("admin") );
	}
}
