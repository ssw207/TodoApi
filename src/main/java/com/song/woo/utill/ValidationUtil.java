package com.song.woo.utill;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class ValidationUtil {
	
	public static void bindingResultCheck(BindingResult result) throws Exception {
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError e : list) {
				throw new Exception(e.getDefaultMessage());
			}
		}
	}
}
