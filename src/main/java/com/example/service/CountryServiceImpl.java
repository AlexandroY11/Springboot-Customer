package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Country;
import com.example.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService{

	private final  CountryRepository countryRepository;
	

	public CountryServiceImpl(CountryRepository countryRepository) {
		super();
		this.countryRepository = countryRepository;
	}

	@Override
	public List<Country> findAll() {
		// TODO Auto-generated method stub
		return countryRepository.findAll();
	}

	@Override
	public Country findById(Integer id) {
		return countryRepository.findById(id).get();
	}

}
