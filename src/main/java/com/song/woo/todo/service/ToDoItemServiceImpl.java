package com.song.woo.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.woo.todo.dao.TodoRepository;
import com.song.woo.todo.model.ToDoItem;

@Service
public class ToDoItemServiceImpl implements ToDoItemService{
	
	@Autowired
	TodoRepository dao;
	
	@Override
	public Optional<ToDoItem> get(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<ToDoItem> list() {
		return dao.findAll();
	}

	@Override
	public ToDoItem save(ToDoItem dto) {
		return dao.save(dto);
	}
	
	@Override
	public void delete(long id) {
		dao.deleteById(id);
	}
	
	@Override
	public ToDoItem update(ToDoItem toDoItem) {
		Optional<ToDoItem> dto = dao.findById(toDoItem.getId());
		if (!dto.isPresent()) return null;
		ToDoItem saveDto = dto.get();
		saveDto.setDone(toDoItem.isDone());
		return dao.save(saveDto);
	}
}
