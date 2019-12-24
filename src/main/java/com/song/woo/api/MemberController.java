package com.song.woo.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public Member save(@RequestBody @Valid Member member, BindingResult result) throws Exception {//String memId, String memPw
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError e : list) {
				throw new Exception(e.getDefaultMessage());
			}
		}
			
		return memberService.memberSave(member);
	}
	
	//로그인
	@PostMapping("/login")
	public Member login(@RequestBody Member member) throws Exception {//String memId, String memPw
		log.info("{}",member);
		 Member mem= memberService.login(member);
		 if (mem == null) throw new Exception("로그인에 실패했습니다.");
		 return mem;
	}
	
	//회원정보 가져오기
	@GetMapping("/info/{memid}")
	public Optional<Member> getInfo(@PathVariable(value="memId") String id) {	
		log.info("info");
		return memberService.getMemberInfo( Long.parseLong(id) );
	}
	
	//회원정보 가져오기
	@GetMapping("/list")
	public List<Member> memberList() {
		return memberService.memberList();
	}
	
//	//회원가입 중복체크
//	@GetMapping("/check/{memId}")
//	public boolean idDuplicateCheck(@PathVariable(value="memId") @RequestBody Member member) {
//		return memberService.getMemberInfo(member).isEmpty();
//	}
}	
