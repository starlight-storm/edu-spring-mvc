package com.example.customer.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.customer.business.service.CustomerService;

@Controller
public class CustomerListController {

	@Autowired
	private CustomerService customerService;

	@GetMapping()
	public String home() {
		return "forward:/customers";
	}

	// TODO: 演習1 メソッドを実装する
}
