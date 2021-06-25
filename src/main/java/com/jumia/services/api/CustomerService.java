package com.jumia.services.api;

import com.jumia.exceptions.BusinessException;
import com.jumia.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getCustomer(Long id) throws BusinessException;

    List<Customer> getCustomers() throws BusinessException;
}

