package com.jumia.facade.impl;

import com.jumia.exceptions.BusinessException;
import com.jumia.facade.api.CustomerFacade;
import com.jumia.model.Country;
import com.jumia.model.Customer;
import com.jumia.services.CustomerServiceBusinessValidation;
import com.jumia.services.api.CountryService;
import com.jumia.services.api.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerFacadeImpl implements CustomerFacade {

    public static final int NOT_VALID = 0;
    public static final int VALID = 1;
    public static final int ALL = -1;

    @Autowired
    private final CustomerService customerService;

    @Autowired
    private final CountryService countryService;

    @Autowired
    private final CustomerServiceBusinessValidation customerServiceBusinessValidation;

    private Country country = null;

    @Override
    public Customer getCustomer(Long id) throws BusinessException {
        return customerService.getCustomer(id);
    }

    @Override
    public List<Customer> getCustomers(long countryId, int state) throws BusinessException {
        List<Customer> customers = customerService.getCustomers();
        log.debug("getCustomers: get customers request for customer countryId: {}, state {} ", countryId, state);
        customerServiceBusinessValidation.validateParametersExistence(countryId, state);
        if (countryId != ALL) {
            country = countryService.getCountryById(countryId);
            List<Customer> customersFiltered = customers.stream()
                    .filter(c -> c.getPhone().substring(1, 4).equals(country.getCode().substring(1)))
                    .collect(Collectors.toList());
            if (state == NOT_VALID) {
                return customersFiltered.stream().filter(c -> !Pattern.matches(country.getRegex(), c.getPhone()))
                        .collect(Collectors.toList());
            }
            if (state == VALID) {
                return customersFiltered.stream().filter(c -> Pattern.matches(country.getRegex(), c.getPhone()))
                        .collect(Collectors.toList());
            }
            return customersFiltered;
        }
        return customers;
    }

    @Override
    public Country getCountryById(Long id) throws BusinessException {
        return countryService.getCountryById(id);
    }

    @Override
    public List<Country> getCountries() throws BusinessException {
        return countryService.getCountries();
    }
}
