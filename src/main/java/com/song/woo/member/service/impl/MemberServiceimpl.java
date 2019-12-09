package com.song.woo.member.service.impl;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.woo.member.dao.MemberDao;
import com.song.woo.member.model.Member;
import com.song.woo.member.service.MemberService;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
		Member memberInfo =memberDao.findByMemId(member.getMemId());
		System.out.println(memberInfo);
		return member.getMemPw().equals(memberInfo.getMemPw()) ? memberInfo : null; 
	}
}
