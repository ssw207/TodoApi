package com.song.woo.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.woo.todo.model.Todo;
import com.song.woo.todo.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService{
	
	@Autowired
	TodoRepository todoRepository;
	
	@Override
	public Optional<Todo> get(Long id) {
		return todoRepository.findById(id);
	}

	@Override
	public List<Todo> list() {
		return todoRepository.findAll();
	}

	@Override
	public Todo save(Todo dto) {
		return todoRepository.save(dto);
	}
	
	@Override
	public void delete(long id) {
		todoRepository.deleteById(id);
	}
	
	@Override
	public Todo update(Todo todo) throws Exception {
		Optional<Todo> o = todoRepository.findById(todo.getId());
		Todo oriTodo = o.orElseThrow(() -> new Exception("잘못된 할 일 입니다."));
		
		oriTodo.setDone(oriTodo.isDone());
		return todoRepository.save(oriTodo);
	}
}
