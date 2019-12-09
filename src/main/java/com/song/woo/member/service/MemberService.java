package com.song.woo.member.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.song.woo.member.model.Member;

@Service
public interface MemberService {
	//저장
	public Member memberSave(Member member);
	//정보조회
	public Optional<Member> getMemberInfo(Long id);
	//로그인
	public Member login(Member member);
}
