package com.song.woo.board;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.song.woo.board.model.Board;
import com.song.woo.board.repository.BoardRepository;
import com.song.woo.member.model.Member;
import com.song.woo.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RunWith(SpringRunner.class)
@DataJpaTest
@RequiredArgsConstructor
public class RelationMappingTest {
	private MemberRepository mr;
	
	private BoardRepository br;
	
	@After
	public void 삭제() {
		mr.deleteAll();
		br.deleteAll();
	}
	
	@Test
	public void 연관관계테스트() {
		Member m1 = mr.save(Member.builder().memName("name1").memId("id1").memPw("pw1").build());
		Member m2 = mr.save(Member.builder().memName("name2").memId("id2").memPw("pw2").build());
		
		for (int i = 0; i<4; i++) {
			br.save(Board.builder().content("content"+i).title("titie"+i).cnt(i).memeber(m1).build());
		}
		
		for (int i = 0; i<4; i++) {
			br.save(Board.builder().content("content"+i).title("titie"+i).cnt(i).memeber(m2).build());
		}
	}
	
}
