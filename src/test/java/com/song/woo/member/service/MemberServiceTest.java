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

import com.song.woo.member.model.Member;
import com.song.woo.member.repository.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceTest {
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	MemberService memberService;
	
	@Test
	public void 회원가입() throws Exception {
		//give
		//when
		Member dto = memberService.memberSave(Member.builder().memId("test123").memPw("1234").memName("test").build());
		
		//then
		assertThat(dto.getMemId()).isEqualTo("test123");
		assertThat(dto.getMemPw()).isEqualTo("1234");
		assertThat(dto.getMemName()).isEqualTo("test");
		memberRepository.delete(dto);
	}
	@Test
	public void 회원정보_단건조회() throws Exception {
		//given
		Member dto = memberService.memberSave(Member.builder().memId("test123").memPw("1234").memName("test").build());
		
		//when
		Member resDto= memberService.getMemberInfo(dto.getMemId());
		
		//then
		assertThat(resDto.getMemId()).isEqualTo("test123");
		assertThat(resDto.getMemPw()).isEqualTo("1234");
		assertThat(resDto.getMemName()).isEqualTo("test");
		memberRepository.delete(dto);
	}
	
	@Test
	public void 회원리스트조회() throws Exception {
		//given
		Member dto1 = memberService.memberSave(Member.builder().memId("test123").memPw("1234").memName("test").build());
		Member dto2 = memberService.memberSave(Member.builder().memId("testA123").memPw("A1234").memName("testA").build());
		
		//when
		List<Member> list = memberService.memberList();
		
		assertThat(list.size()).isEqualTo(2);
		
		memberRepository.delete(dto1);
		memberRepository.delete(dto2);
	}
	
	@Test
	public void 로그인() throws Exception {		
		//given
		Member dto = memberService.memberSave(Member.builder().memId("test123").memPw("1234").memName("test").build());
		
		//when
		Optional<Member> o = memberService.login(dto);
		Member resDto = o.orElseThrow(()-> new Exception("아이디, 비밀번호를 확인해 주세요"));
		
		//then
		assertThat(resDto.getMemId()).isEqualTo("test123");
		assertThat(resDto.getMemPw()).isEqualTo("1234");
		
		memberRepository.delete(dto);
	}
	
	@Test
	public void 아이디_중복체크() throws Exception {
		//before
		Member dto = memberService.memberSave(Member.builder().memId("test123").memPw("1234").memName("test").build());
		
		//after
		boolean isDuplicate = memberService.isDuplicateId(dto.getMemId());
		
		assertTrue(isDuplicate);
		
		memberRepository.delete(dto);
	}
}
