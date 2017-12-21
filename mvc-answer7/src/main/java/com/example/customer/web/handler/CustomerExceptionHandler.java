package com.example.customer.web.handler;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.customer.common.exception.DataNotFoundException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class CustomerExceptionHandler {
	
	@Autowired
    private MessageSource messageSource;
	
	@ExceptionHandler(DataNotFoundException.class)
	public String notFoundException(Locale locale) {
		log.error("*** " + messageSource.getMessage("errors.datanotfound.customer", null, locale) + "***");
		return "/customer/notfound";
	}
}