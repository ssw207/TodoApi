package com.song.woo.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/*모든 컨트롤러 에러 처리*/
@ControllerAdvice
public class GlobalExceptionHandler {
	
	/* 에러발생시 에러메시지 리턴 */
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public String handelCustomException(Exception exception, Model model) {
		return exception.getMessage();
	}
}
