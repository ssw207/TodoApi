package com.song.woo.member.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.woo.member.dao.MemberDao;
import com.song.woo.member.model.Member;
import com.song.woo.member.service.MemberService;

@Service
public class MemberServiceimpl implements MemberService{
	@Autowired
	MemberDao memberDao;
	
	@Override
	public Member memberSave(Member member) {
		return memberDao.save(member);
	}

	@Override
	public Optional<Member> getMemberInfo(Long id) {
		return memberDao.findById(id);
	}

	@Override
	public Member login(Member member) {
		Optional<Member> o = memberDao.findByMemId(member.getMemId());
		Member memberInfo = o.orElseThrow();
		return member.getMemPw().equals(memberInfo.getMemPw()) ? memberInfo : null; 
	}

	@Override
	public List<Member> memberList() {
		return memberDao.findAll();
	}

	@Override
	public boolean isDuplicateId(String memId) {
		Optional<Member> o = memberDao.findByMemId(memId);
		return o.isPresent();
	}
}
