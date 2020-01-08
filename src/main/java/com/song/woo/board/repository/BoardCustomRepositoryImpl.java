package com.song.woo.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.song.woo.board.model.Board;
import com.song.woo.board.model.QBoard;

/**
 * Querydsl를 이용해서 세부 조회 구현 
 */
public class BoardCustomRepositoryImpl extends QuerydslRepositorySupport implements BoardCustomRepository{

	public BoardCustomRepositoryImpl() {
		super(Board.class);
	}

	@Override
	public List<Board> findRecentlyRegistered(int limit) {
		final QBoard board = QBoard.board;
		return 	from(board)
				.limit(limit)
				.orderBy(board.dtFrt.desc())
				.fetch();
	}
}
