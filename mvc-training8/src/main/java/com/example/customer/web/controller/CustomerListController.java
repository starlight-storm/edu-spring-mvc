package com.example.customer.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.customer.business.domain.Customer;
import com.example.customer.business.service.CustomerService;

@Controller
public class CustomerListController {

	@Autowired
	private CustomerService customerService;

	@GetMapping(value = "/")
	public String home() {
		return "forward:/customer";
	}

	@GetMapping(value = "/customer")
	public String showAllCustomers(Model model) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		return "customer/list";
	}

	// TODO: ページネイションに対応させる
	@GetMapping(value = "/customer/{customerId}")
	public String showCustomerDetail(@PathVariable int customerId, Model model) {
		Customer customer = customerService.findById(customerId);
		model.addAttribute("customer", customer);
		return "customer/detail";
	}
}
