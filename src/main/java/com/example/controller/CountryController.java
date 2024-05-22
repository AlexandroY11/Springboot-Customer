package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Country;
import com.example.service.CountryService;

@RestController
@RequestMapping("/countries")
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController {
	
	private final CountryService countryService;

	public CountryController(CountryService countryService) {
		super();
		this.countryService = countryService;
	}

	@GetMapping("")
	public List<Country> findAll() {
		return countryService.findAll();
	}
	
	@GetMapping("/{idCountry}")
	public Country findById(@PathVariable("idCountry") Integer id) {
		return countryService.findById(id);
	}
	
	 
	
}
