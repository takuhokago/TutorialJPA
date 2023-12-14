package com.techacademy;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CountryService {
    private final CountryRepository repository;

    @Autowired
    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public List<Country> getCountryList() {
        return repository.findAll();
    }

    public Country getCountry(String code) {
        Optional<Country> option = repository.findById(null);
        Country country = option.orElse(null);
        return country;
    }

    @Transactional
    public void updateCountry(String code, String name, int population) {
        Country country = new Country(code, name, population);
        repository.save(country);
    }

    @Transactional
    public void deleteCountry(String code) {
        repository.deleteById(code);
    }
}
