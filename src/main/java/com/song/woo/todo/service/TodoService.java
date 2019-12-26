package com.song.woo.todo.service;

import java.util.List;
import java.util.Optional;

import com.song.woo.todo.model.Todo;

public interface TodoService {
	/**
	 * 할일 조회
	 * @param id
	 * @return
	 */
	public Optional<Todo> get(Long id);
	/**
	 * 할일 저장
	 * @param todo
	 * @return
	 */
	public Todo save(Todo todo);
	/**
	 * 할일 목록
	 * @return
	 */
	public List<Todo> list();
	/**
	 * 할일 삭제
	 * @param id
	 */
	public void delete(long id);
	/**
	 * 할일 수정
	 * @param todo
	 * @return
	 * @throws Exception
	 */
	public Todo update(Todo todo) throws Exception;
}
