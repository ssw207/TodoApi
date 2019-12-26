package com.song.woo.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.song.woo.member.model.Member;
import com.song.woo.member.service.MemberService;
import com.song.woo.utill.ValidationUtil;

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
		ValidationUtil.bindingResultCheck(result);
		return memberService.memberSave(member);
	}
	
	//로그인
	@PostMapping("/login")
	public Member login(@RequestBody Member member) throws Exception {//String memId, String memPw
		log.debug("{}",member);
		 Optional<Member> oMember = memberService.login(member);
		 return oMember.orElseThrow(() -> new Exception("로그인에 실패 했습니다."));
	}
	
	//회원정보 가져오기
	@GetMapping("/{memid}")
	public Member getInfo(@PathVariable(value="memId") String memId) {	
		return memberService.getMemberInfo(memId);
	}
	
	//회원정보 가져오기
	@GetMapping("/list")
	public List<Member> memberList() {
		return memberService.memberList();
	}
	
	//회원가입 중복체크
	@GetMapping("/check/{memId}")
	public boolean idDuplicateCheck(@PathVariable(value="memId") String memId) {
		return memberService.isDuplicateId(memId);
	}
}	
