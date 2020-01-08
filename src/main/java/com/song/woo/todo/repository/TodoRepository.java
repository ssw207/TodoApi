package com.song.woo.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.song.woo.board.model.Board;
import com.song.woo.todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> , QuerydslPredicateExecutor<Board>{
}
