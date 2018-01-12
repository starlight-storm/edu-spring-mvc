package com.example.customer.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.customer.business.domain.Customer;
import com.example.customer.business.repository.CustomerRepository;
import com.example.customer.common.exception.DataNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	@Transactional(readOnly=true)
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Customer findById(int id) {
		Customer customer = customerRepository.findById(id);
		if(customer == null) throw new DataNotFoundException();
		return customer;
	}

	@Override
	@Transactional
	public void update(Customer customer) {
		customerRepository.update(customer);
	}

	@Override
	public Customer register(Customer customer) {
		// 演習では利用していないので、実装していません
		return null;
	}
	
	@Override
	public void delete(int id) {
		// 演習では利用していないので、実装していません
	}
}
