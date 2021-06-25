package com.jumia.facade.api;

import com.jumia.exceptions.BusinessException;
import com.jumia.model.Country;
import com.jumia.model.Customer;

import java.util.List;

public interface CustomerFacade {

    Customer getCustomer(Long id) throws BusinessException;
    List<Customer> getCustomers(long countryId, int state) throws BusinessException;
    Country getCountryById(Long id) throws BusinessException;

    List<Country> getCountries() throws BusinessException;

}
