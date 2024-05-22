package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{

}
