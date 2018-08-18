package com.example.customer.business.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.customer.business.domain.Customer;

@Mapper
public interface CustomerRepository {

	@Select("SELECT ID, NAME, ADDRESS, EMAIL_ADDRESS, MEMBERSHIP_TYPE, EMAIL_NOTIFICATION FROM CUSTOMER")
	public List<Customer> findAll();

	@Select("SELECT * FROM CUSTOMER WHERE ID = #{id}")
	public Customer findById(int id);

	@Update("UPDATE CUSTOMER SET NAME=#{name}, ADDRESS=#{address}, EMAIL_ADDRESS=#{emailAddress}, MEMBERSHIP_TYPE=#{membershipType}, EMAIL_NOTIFICATION=#{emailNotification} WHERE ID = #{id}")
	public void update(Customer customer);

}
