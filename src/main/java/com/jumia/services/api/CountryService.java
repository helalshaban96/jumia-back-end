package com.jumia.services.api;

import com.jumia.exceptions.BusinessException;
import com.jumia.model.Country;

import java.util.List;

public interface CountryService {
    Country getCountryById(Long id) throws BusinessException;

    List<Country> getCountries() throws BusinessException;
}
