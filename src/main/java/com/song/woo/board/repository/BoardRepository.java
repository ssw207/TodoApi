package com.song.woo.board.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.song.woo.board.model.Board;


public interface BoardRepository extends JpaRepository<Board, Long> {
	//title로 검색
	List<Board> findByTitle(String title);
	
	//content에 keyword로 검색
	List<Board> findByContentContaining(String searchKeyword);
	
	//or검색
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	//like검색정렬
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	
	//페이징 검색
	Page<Board> findByTitleContaining(String k, Pageable paging);
	
//	//쿼리 검색어로 검색 
//	@Query("SELECT b FROM Board b " 
//			+ "WHERE b.title like %:searchKeyword%  " 
//			+ "ORDER BY b.seq DESC")
//	List<Board> queryAnnotationTest1(@Param("searchKeyword") String searchKeyword);
//	
//	//쿼리 검색로 검색후 원하는 데이터만 출력 
//	@Query("SELECT b.seq, b.title, b.memId " 
//			+ "FROM Board b " 
//			+ "WHERE b.title like %?1% "
//			+ "ORDER BY b.seq DESC")
//	List<Object[]> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);
//	
//	//네이티브 쿼리사용 - board는 테이블 ,sql연산자 || 사용
//	@Query(value = "select seq, title, mem_id " 
//					+ "from board where title like '%'||?1||'%' "
//					+ "order by seq desc", nativeQuery = true)
//	List<Object[]> queryAnnotationTest3(String searchKeyword);
}
