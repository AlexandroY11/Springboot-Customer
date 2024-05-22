package com.example.service;

import java.util.List;
import com.example.model.Country;

public interface CountryService {
	
	List<Country> findAll();
	Country findById(Integer id);
	
}
