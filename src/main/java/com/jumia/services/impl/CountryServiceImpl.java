package com.jumia.services.impl;

import com.jumia.entities.CountryEntity;
import com.jumia.enums.ErrorCode;
import com.jumia.exceptions.BusinessException;
import com.jumia.model.Country;
import com.jumia.repositories.CountryRepository;
import com.jumia.repositories.CustomerRepository;
import com.jumia.services.CustomerServiceBusinessValidation;
import com.jumia.services.api.CountryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl extends CustomerServiceBusinessValidation implements CountryService {
    public CountryServiceImpl(CustomerRepository customerRepository,
                              CountryRepository countryRepository, ModelMapper modelMapper, ObjectMapper objectMapper) {
        super(customerRepository, countryRepository, modelMapper, objectMapper);
    }

    @Override
    public Country getCountryById(Long id) throws BusinessException {
        return countryRepository.findById(id)
                .map(countryEntity -> modelMapper.map(countryEntity, Country.class))
                .orElseThrow(() -> new BusinessException(ErrorCode.NOT_EXIST));
    }

    @Override
    public List<Country> getCountries() throws BusinessException {
        List<CountryEntity> list = countryRepository.findAll();
        return list
                .stream()
                .map(element -> modelMapper.map(element, Country.class))
                .collect(Collectors.toList());
    }
}
