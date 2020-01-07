package com.song.woo.board.repository;

import java.util.List;

import com.song.woo.board.model.Board;

public interface BoardCustomRepository {
	/**
	 * 최근 등록한 글을 limit 개수만큼 가져온다
	 * @param limit
	 * @return
	 */
	List<Board> findRecentlyRegistered(int limit);
}
