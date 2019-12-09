package com.song.woo.common.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.song.woo.todo.model.ToDoItem;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor // 작동을 안함
public abstract class ApiResponse<T> {
	@NotNull private T data;
	private List<String> errors;
	
	public ApiResponse(T data) {
		this.data = data;
	}
}
