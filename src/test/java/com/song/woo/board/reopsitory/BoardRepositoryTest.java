package com.song.woo.board.reopsitory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.core.BooleanBuilder;
import com.song.woo.board.model.Board;
import com.song.woo.board.model.QBoard;
import com.song.woo.board.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
	@Autowired
	private BoardRepository r;
	
	@After
	public void 삭제() {
		r.deleteAll();
	}

	@Test
	public void 게시글_저장_삭제() {
		// when
		Board dto = r.save(Board.builder().title("제목").content("내용").cnt(1).build());

		// then
		assertThat(dto.getTitle()).isEqualTo("제목");
	}

	@Test
	public void 게시글_단일조회() {
		// given
		Board dto = r.save(Board.builder().title("제목").content("내용").cnt(1).build());

		// when
		Optional<Board> o = r.findById(dto.getSeq());
		Board resDto = o.orElseThrow();

		// then
		assertThat(resDto.getTitle()).isEqualTo("제목");
	}

	@Test
	public void 게시글_수정() {
		// given
		Board savedDto = r.save(Board.builder().title("제목").content("내용").cnt(1).build());

		// when
		Optional<Board> o = r.findById(savedDto.getSeq());
		Board dto = o.orElseThrow();
		dto.setTitle("변경된제목");
		Board modifiedDto = r.save(dto);

		// then
		assertThat(modifiedDto.getTitle()).isEqualTo("변경된제목");
	}

	@Test
	public void 게시글_목록조회() {
		// given
		Board savedDto1 = r.save(Board.builder().title("제목").content("내용").cnt(1).build());
		Board savedDto2 = r.save(Board.builder().title("제목").content("내용").cnt(1).build());

		// when
		List<Board> list = r.findAll();

		// then
		assertThat(list.size()).isEqualTo(2);
	}
	
	@Test
	public void 게시글_eq검색() {
		// given
		for (int i = 1; i < 10; i++) {
			r.save(Board.builder().title("제목" + i).content("내용" + i).cnt(i).build());
		}

		// when
		List<Board> list = r.findByTitle("제목5");

		// then
		assertThat(list.get(0).getTitle()).isEqualTo("제목5");
	}
	
	@Test
	public void 게시글_like검색() {
		// given
		for (int i = 1; i < 10; i++) {
			r.save(Board.builder().title("제목" + i).content("내용" + i).cnt(i).build());
		}

		// when
		List<Board> list = r.findByContentContaining("5");

		// then
		assertThat(list.size()).isNotEqualTo(0);
		assertThat(list.get(0).getContent()).isEqualTo("내용5");
	}
	
	@Test
	public void 게시글_or_like검색() {
		// given
		for (int i = 1; i < 10; i++) {
			r.save(Board.builder().title("제목" + i).content("내용" + i).cnt(i).build());
		}
		
		// when
		List<Board> list = r.findByTitleContainingOrContentContaining("목4", "용5");
		
		// then
		assertThat(list.size()).isEqualTo(2);
		assertThat(list.get(0).getTitle()).isEqualTo("제목4");
		assertThat(list.get(1).getContent()).isEqualTo("내용5");
	}
	
	@Test
	public void 게시글_like검색_정렬() {
		// given
		for (int i = 1; i <= 10; i++) {
			r.save(Board.builder().title("제목" + i).content("내용" + i).cnt(i).build());
		}
		
		// when
		List<Board> list = r.findByTitleContainingOrderBySeqDesc("제목");
		
		// then
		assertThat(list.size()).isEqualTo(10);
		assertThat(list.get(0).getSeq()).isEqualTo(10);
	}
	
	@Test
	public void 게시글_like검색_페이징() {
		// given
		for (int i = 1; i <= 200; i++) {
			r.save(Board.builder().title("제목" + i).content("내용" + i).cnt(i).build());
		}
		
		// when
		Pageable paging = PageRequest.of(0,5, Sort.Direction.DESC, "seq"); // 페이지당 5, seq desc정렬
		Page<Board> pageInfo = r.findByTitleContaining("제목", paging);
		
		// then
		log.debug("NEXT : " + pageInfo.nextPageable()); // 다음페이지 정보 NEXT : Page request [number: 1, size 5, sort: seq: DESC]
		
		assertThat(pageInfo.getSize()).isEqualTo(5); // 한페이지 row수
		assertThat(pageInfo.getTotalPages()).isEqualTo(40);// 전체 페이지수
		assertThat(pageInfo.getTotalElements()).isEqualTo(200);// 전체 row수
	}
	
//	@Test
//	public void 게시글_쿼리검색() {
//		// given
//		for (int i = 1; i <= 10; i++) {
//			r.save(Board.builder().title("제목" + i).content("내용" + i).cnt(i).build());
//		}
//		
//		log.debug("쿼리로 검색조건에 일치하는 모든컬럼 검색");
//		// when
//		List<Board> list = r.queryAnnotationTest1("목1");
//		for(Board board : list) {
//			log.debug(board.toString());
//		}
//		
//		log.debug("쿼리로 검색조건에 일치하는 지정 컬럼만 검색");
//		// when
//		List<Object[]> list2 = r.queryAnnotationTest2("목1");
//		for(Object[] row : list2) {
//			log.debug(Arrays.toString(row));
//		}
//		
//		log.debug("네이티브 쿼리로 검색조건에 일치하는 지정 컬럼만 검색");
//		// when
//		List<Object[]> list3 = r.queryAnnotationTest3("목1");
//		for(Object[] row : list3) {
//			log.debug(Arrays.toString(row));
//		}
//		
//		r.deleteAll();
//	}
	
	@Test
	public void 검색조건_테스트() {
		//given
		String searchCondition = "CONTENT";
		String keyword = "내용10";
		
		for (int i = 1; i <= 20; i++) {
			r.save(Board.builder().title("제목" + i).content("내용" + i).cnt(i).build());
		}
		
		//when
		BooleanBuilder builder = new BooleanBuilder();
		
		QBoard qBoard = QBoard.board;
		
		if(searchCondition.equals("TITLE")) {
			builder.and(qBoard.title.like("%" + keyword + "%"));
		} else if (searchCondition.equals("CONTENT")) {
			builder.and(qBoard.content.like("%" + keyword + "%"));
		}
		
		Pageable paging = PageRequest.of(0, 5);
		Page<Board> pageInfo = r.findAll(builder, paging);
		
		//then
		assertThat(pageInfo.getTotalElements()).isEqualTo(1);
	}
}
