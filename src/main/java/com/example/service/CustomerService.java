package com.example.service;

import java.util.List;

import com.example.model.Customer;

public interface CustomerService {
	
	Customer save(Customer customer);
	
	List<Customer> findAll();
	Customer findById(Integer id);
	void deleteById(Integer id);
	Customer update(Customer customer);
}
