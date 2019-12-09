package com.song.woo.todo.model;

import java.util.List;

import com.song.woo.common.model.ApiResponse;

import lombok.Builder;

public class ToDoItemResponse extends ApiResponse<ToDoItem> {
	
	@Builder
	public ToDoItemResponse(final ToDoItem todoItem, final List<String> errors) {
		super(todoItem);
		this.setErrors(errors);
	}
}
