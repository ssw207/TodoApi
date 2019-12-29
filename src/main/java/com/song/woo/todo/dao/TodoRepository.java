package com.song.woo.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.song.woo.todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
}
