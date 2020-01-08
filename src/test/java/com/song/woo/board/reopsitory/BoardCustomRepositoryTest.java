package com.song.woo.board.reopsitory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.song.woo.board.model.Board;
import com.song.woo.board.repository.BoardRepository;


@RunWith(SpringRunner.class)
@DataJpaTest // jpa 관련 기능 의존성만 추가
public class BoardCustomRepositoryTest {
	
	@Autowired
	private BoardRepository r;
	
	@After
	public void 데이터삭제() {
		r.deleteAll();
	}
	
	@Before
	public void 데이터저장() {
		for (int i = 1; i <= 10; i++) {
			r.save(Board.builder()
							.title("title"+i)
							.content("content"+i)
							.build());
		}
		
	}
	
	@Test
	public void 최근등록글_테스트() {
		//when
		List<Board> list = r.findRecentlyRegistered(2);
		
		//then
		assertThat(list.size()).isEqualTo(2);
		assertThat(list.get(0).getTitle()).isEqualTo("title10");
	}
}
