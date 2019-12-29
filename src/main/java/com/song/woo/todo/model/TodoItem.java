package com.song.woo.todo.model;

import java.util.List;

import com.song.woo.common.model.ApiResponse;

import lombok.Builder;

public class TodoItem extends ApiResponse<Todo> {
	
	@Builder
	public TodoItem(final Todo todoItem, final List<String> errors) {
		super(todoItem);
		this.setErrors(errors);
	}
}
