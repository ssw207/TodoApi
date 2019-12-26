package com.song.woo.member.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.song.woo.member.dao.MemberDao;
import com.song.woo.member.model.Member;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceTest {
	@Autowired
	MemberDao dao;
	
	@Autowired
	MemberService service;
	
	@Test
	public void 회원가입() throws Exception {
		//give
		//when
		Member dto = service.memberSave(Member.builder().memId("test123").memPw("1234").memName("test").build());
		
		//then
		assertThat(dto.getMemId()).isEqualTo("test123");
		assertThat(dto.getMemPw()).isEqualTo("1234");
		assertThat(dto.getMemName()).isEqualTo("test");
		dao.delete(dto);
	}
	@Test
	public void 회원정보_단건조회() throws Exception {
		//given
		Member dto = service.memberSave(Member.builder().memId("test123").memPw("1234").memName("test").build());
		
		//when
		Member resDto= service.getMemberInfo(dto.getMemId());
		
		//then
		assertThat(resDto.getMemId()).isEqualTo("test123");
		assertThat(resDto.getMemPw()).isEqualTo("1234");
		assertThat(resDto.getMemName()).isEqualTo("test");
		dao.delete(dto);
	}
	
	@Test
	public void 회원리스트조회() throws Exception {
		//given
		Member dto1 = service.memberSave(Member.builder().memId("test123").memPw("1234").memName("test").build());
		Member dto2 = service.memberSave(Member.builder().memId("testA123").memPw("A1234").memName("testA").build());
		
		//when
		List<Member> list = service.memberList();
		
		assertThat(list.size()).isEqualTo(2);
		
		dao.delete(dto1);
		dao.delete(dto2);
	}
	
	@Test
	public void 로그인() throws Exception {		
		//given
		Member dto = service.memberSave(Member.builder().memId("test123").memPw("1234").memName("test").build());
		
		//when
		Optional<Member> o = service.login(dto);
		Member resDto = o.orElseThrow(()-> new Exception("아이디, 비밀번호를 확인해 주세요"));
		
		//then
		assertThat(resDto.getMemId()).isEqualTo("test123");
		assertThat(resDto.getMemPw()).isEqualTo("1234");
		
		dao.delete(dto);
	}
	
	@Test
	public void 아이디_중복체크() throws Exception {
		//before
		Member dto = service.memberSave(Member.builder().memId("test123").memPw("1234").memName("test").build());
		
		//after
		boolean isDuplicate = service.isDuplicateId(dto.getMemId());
		
		assertTrue(isDuplicate);
		
		dao.delete(dto);
	}
}
