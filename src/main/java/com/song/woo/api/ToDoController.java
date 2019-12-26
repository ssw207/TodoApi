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

import com.song.woo.todo.model.ToDoItem;
import com.song.woo.todo.service.ToDoItemService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/todo")
@RestController
public class ToDoController {
	@Autowired
	private ToDoItemService toDoItemService;
	
	@PostMapping("/save")
	public ToDoItem save(@RequestBody ToDoItem dto) {
		log.info(dto.toString());
		return toDoItemService.save(dto);
	}
	
	@GetMapping("/{id}")
	public Optional<ToDoItem> get(@PathVariable(value="id") Long id) {
		return toDoItemService.get(id);
	}
	
	@GetMapping("/list")
	public List<ToDoItem> list() {
		return toDoItemService.list();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
 		toDoItemService.delete(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody ToDoItem toDoItem) {
		toDoItemService.update(toDoItem);
	}
}	
