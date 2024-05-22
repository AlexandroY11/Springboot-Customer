package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Country;
import com.example.model.Customer;
import com.example.service.CountryService;
import com.example.service.CustomerService;


@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	private final CustomerService customerService;
	private final CountryService countryService;

	public CustomerController(CustomerService customerService, CountryService countryService) {
		this.customerService = customerService;
		this.countryService = countryService;
	}
	
	@PostMapping("/create")
	public Customer save(@RequestBody Customer customer) {
		return customerService.save(customer); 
	}
	
	@GetMapping("")
	public List<Customer> findAll(){
		return customerService.findAll();
	}
	
	@GetMapping("/{idCustomer}")
	public Customer findById(@PathVariable("idCustomer") Integer id) {
		return customerService.findById(id);
	}
	
	@DeleteMapping("/{idCustomer}")
	public void deleteById(@PathVariable("idCustomer") Integer id) {
		customerService.deleteById(id); 
	}
	
	@PutMapping
	public Customer update(@RequestBody Customer customer) {

		Customer customerDB = customerService.findById(customer.getId());
		customerDB.setFirstName(customer.getFirstName());
		customerDB.setLastName(customer.getLastName());
		customerDB.setEmail(customer.getEmail());
		if (customer.getCountry() != null) {
	        Country country = countryService.findById(customer.getCountry().getId());
	        customerDB.setCountry(country);
	    }
		
		return customerService.update(customerDB);

    }
	
	
}
