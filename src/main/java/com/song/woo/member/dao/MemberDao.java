package com.song.woo.member.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.song.woo.member.model.Member;

public interface MemberDao extends JpaRepository<Member, Long> {
	Optional<Member> findByMemId(String memId);
}
