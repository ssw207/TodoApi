package com.song.woo.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.song.woo.todo.model.ToDoItem;

public interface TodoRepository extends JpaRepository<ToDoItem, Long>{
}
