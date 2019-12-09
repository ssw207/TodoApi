package com.song.woo.todo.service;

import java.util.List;
import java.util.Optional;

import com.song.woo.todo.model.ToDoItem;

public interface ToDoItemService {
	
	public Optional<ToDoItem> get(Long id);
	public ToDoItem save(ToDoItem dto);
	public List<ToDoItem> list();
	public void delete(long id);
	public ToDoItem update(ToDoItem toDoItem);
}
