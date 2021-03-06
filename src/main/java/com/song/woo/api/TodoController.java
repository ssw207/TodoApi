package com.song.woo.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.song.woo.todo.model.Todo;
import com.song.woo.todo.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/todo")
@RestController
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	@PostMapping("/save")
	public Todo save(@RequestBody Todo dto) {
		log.info(dto.toString());
		return todoService.save(dto);
	}
	
	@GetMapping("/{id}")
	public Optional<Todo> get(@PathVariable(value="id") Long id) {
		return todoService.get(id);
	}
	
	@GetMapping("/list")
	public List<Todo> list() {
		return todoService.list();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
 		todoService.delete(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Todo toDoItem) throws Exception {
		todoService.update(toDoItem);
	}
}	
