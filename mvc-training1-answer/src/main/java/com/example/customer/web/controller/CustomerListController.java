package com.example.customer.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.customer.business.domain.Customer;
import com.example.customer.business.service.CustomerService;

@Controller
public class CustomerListController {

	@Autowired
	private CustomerService customerService;

	@GetMapping()
	public String home() {
		return "forward:/customer";
	}

	@GetMapping("/customer")
	public String showAllCustomers(Model model) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		return "customer/list";
	}
}
