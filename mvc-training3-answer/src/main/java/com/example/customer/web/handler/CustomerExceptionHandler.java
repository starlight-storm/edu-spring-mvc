package com.example.customer.web.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.customer.common.exception.DataNotFoundException;

@ControllerAdvice
public class CustomerExceptionHandler {
	@ExceptionHandler(DataNotFoundException.class)
	public String notFoundException() {
		return "/customers/notfound";
	}
}