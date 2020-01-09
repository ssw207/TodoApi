package com.song.woo.board;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.core.BooleanBuilder;
import com.song.woo.board.model.Board;
import com.song.woo.board.model.QBoard;
import com.song.woo.board.repository.BoardRepository;
import com.song.woo.member.model.Member;
import com.song.woo.member.repository.MemberRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RelationMappingTest {
	@Autowired
	private MemberRepository mr;
	@Autowired
	private BoardRepository br;
	
	@After
	public void 삭제() {
		mr.deleteAll();
		br.deleteAll();
	}
	
//	@Test
	public void 연관관계저장() {
		//given
		Member m1 = mr.save(Member.builder().memName("name1").memId("id1").memPw("pw1").build());
		
		//when
		for (int i = 0; i<4; i++) {
			br.save(Board.builder().content("content"+i).title("titie"+i).cnt(i).memeber(m1).build());
		}
		
		//then
		assertThat(br.findAll().get(0).getMemeber().getMemId()).isEqualTo("id1");
	}
	
	@Test
	public void 게시글상세조회() {
		//given
		Member m1 = mr.save(Member.builder().memName("name1").memId("id1").memPw("pw1").build());
		
		for (int i = 0; i<1; i++) {
			br.save(Board.builder().content("content"+i).title("titie"+i).cnt(i).memeber(m1).build());
		}
				
		//when
		//@ManyToOne 기본속성은 EAGER이므로 회원정보도 같이조회
		Board board = br.findById(1L).get();
		
		//then
		assertThat(board.getMemeber().getMemName()).isEqualTo("name1");
	}
	
}
