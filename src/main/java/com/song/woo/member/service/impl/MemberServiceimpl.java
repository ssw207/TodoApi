package com.song.woo.member.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.woo.member.model.Member;
import com.song.woo.member.repository.MemberRepository;
import com.song.woo.member.service.MemberService;

@Service
public class MemberServiceimpl implements MemberService{
	@Autowired
	MemberRepository memberRepository;
	
	@Override
	public Member memberSave(Member member) throws Exception {
		if (isDuplicateId(member.getMemId())) {
			throw new Exception("중복된 아이디 입니다.");
		}
		return memberRepository.save(member);
	}

	@Override
	public Member getMemberInfo(String memId) {
		return memberRepository.findByMemId(memId);
	}

	@Override
	public Optional<Member> login(Member member) {
		Member resMember = memberRepository.findByMemId(member.getMemId());
		return member.getMemPw().equals(resMember.getMemPw()) ? Optional.of(resMember) : Optional.empty(); 
	}

	@Override
	public List<Member> memberList() {
		return memberRepository.findAll();
	}

	@Override
	public boolean isDuplicateId(String memId) {
		Member resMember = memberRepository.findByMemId(memId);
		return (resMember == null) ? false : true;
	}
}
