package com.example.customer.business.service;

import java.util.List;

import com.example.customer.business.domain.Customer;

public interface CustomerService {
	public List<Customer> findAll();

	public Customer findById(int id);

	public Customer register(Customer customer);

	public void update(Customer customer);

	public void delete(int id);
}
