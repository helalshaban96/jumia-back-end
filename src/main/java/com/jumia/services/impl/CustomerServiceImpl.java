package com.jumia.services.impl;

import com.jumia.entities.CustomerEntity;
import com.jumia.enums.ErrorCode;
import com.jumia.exceptions.BusinessException;
import com.jumia.model.Customer;
import com.jumia.repositories.CountryRepository;
import com.jumia.repositories.CustomerRepository;
import com.jumia.services.CustomerServiceBusinessValidation;
import com.jumia.services.api.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CustomerServiceImpl extends CustomerServiceBusinessValidation implements CustomerService {

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CountryRepository countryRepository, ModelMapper modelMapper, ObjectMapper objectMapper) {
        super(customerRepository, countryRepository, modelMapper, objectMapper);
    }

    @Override
    public Customer getCustomer(Long id) throws BusinessException {
        log.debug("getCustomer: getting customer {} ", id);
        return customerRepository.findById(id)
                .map(customerEntity -> modelMapper.map(customerEntity, Customer.class))
                .orElseThrow(() -> new BusinessException(ErrorCode.NOT_EXIST));
    }

    @Override
    public List<Customer> getCustomers() {
        log.debug("getCustomer: getting customers {} ");
        List<CustomerEntity> list = customerRepository.findAll();

        return list
                .stream()
                .map(element -> modelMapper.map(element, Customer.class))
                .collect(Collectors.toList());
    }
}
