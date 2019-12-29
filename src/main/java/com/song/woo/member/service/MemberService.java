package com.song.woo.member.service;



import java.util.List;
import java.util.Optional;

import com.song.woo.member.model.Member;


public interface MemberService {
	//저장
	public Member memberSave(Member member) throws Exception;
	
	//정보조회
	public Member getMemberInfo(String memId);
	
	//로그인
	public Optional<Member> login(Member member);
	
	//리스트
	public List<Member> memberList();
	
	//아이디 중복체크
	public boolean isDuplicateId(String memId);
}
