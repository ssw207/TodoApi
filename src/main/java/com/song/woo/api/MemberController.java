package com.song.woo.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.song.woo.member.model.Member;
import com.song.woo.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/member")
@RestController
public class MemberController {
	@Autowired
	private MemberService memberService;
	//회원가입
	@PostMapping("/save")
	public Member save(Member member) {//String memId, String memPw
		return memberService.memberSave(member);
	}
	
	//로그인
	@PostMapping("/login")
	public Member login(Member member) {//String memId, String memPw
		log.info("login");
		 Member mem= memberService.login(member);
		 log.info("login, {}", mem);
		 return mem;
	}
	
	//회원정보 가져오기
	@GetMapping("/info")
	public Optional<Member> getInfo(String id) {	
		log.info("info");
		return memberService.getMemberInfo( Long.parseLong(id) );
	}
	
	
}	
