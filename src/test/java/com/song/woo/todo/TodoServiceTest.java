package com.song.woo.todo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.song.woo.todo.dao.TodoRepository;
import com.song.woo.todo.model.Todo;
import com.song.woo.todo.service.TodoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoServiceTest {
//	public Optional<Todo> get(Long id);
//	public void delete(long id);
	
	@Autowired
	TodoRepository todoRepository;
	
	@Autowired
	TodoService todoService;
	
	@Test
	public void todo저장() {
		//given
		//when
		Todo dto = todoService.save(Todo.builder().title("todo1").done(true).build());
		
		//then
		assertThat(dto.getTitle()).isEqualTo("todo1");
		assertThat(dto.isDone()).isEqualTo(true);
		
		todoRepository.delete(dto);
	}
	
	@Test
	public void todo조회() {
		//given
		Todo dto = todoService.save(Todo.builder().title("todo1").done(true).build());
		
		//when
		Optional<Todo> o = todoService.get(dto.getId());
		Todo resDto = o.orElseThrow();
		
		//then
		assertThat(resDto.getTitle()).isEqualTo(dto.getTitle());
		assertThat(resDto.isDone()).isEqualTo(dto.isDone());
		
		todoRepository.delete(dto);
	}
	
	@Test
	public void todo목록() {
		//given
		Todo dto1 = todoService.save(Todo.builder().title("todo1").done(true).build());
		Todo dto2 = todoService.save(Todo.builder().title("todo1").done(true).build());
		
		//when
		List<Todo> list = todoService.list();
		
		//then
		assertThat(list.size()).isEqualTo(2);
		
		todoRepository.delete(dto1);
		todoRepository.delete(dto2);
	}
	@Test
	public void todo수정() throws Exception {
		//given
		Todo dto = todoService.save(Todo.builder().title("todo1").done(true).build());
		
		//when
		dto.setDone(false);
		todoService.update(dto);
		
		//then
		Optional<Todo> o = todoService.get(dto.getId());
		Todo todo = o.orElseThrow();
		
		assertThat(todo.isDone()).isEqualTo(false);
		
		todoRepository.delete(dto);
	}

	@Test
	public void todo삭제() {
		//given
		Todo dto = todoService.save(Todo.builder().title("todo1").done(true).build());
		
		//when
		todoService.delete(dto.getId());
		
		//then
		Optional<Todo> o = todoService.get(dto.getId());
		
		assertThat(o.isEmpty()).isEqualTo(true);
	}
}
