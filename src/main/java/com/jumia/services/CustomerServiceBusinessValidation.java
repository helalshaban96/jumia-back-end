package com.jumia.services;

import com.jumia.enums.ErrorCode;
import com.jumia.exceptions.BusinessException;
import com.jumia.repositories.CountryRepository;
import com.jumia.repositories.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class CustomerServiceBusinessValidation {

    protected CustomerRepository customerRepository;
    protected CountryRepository countryRepository;

    protected ModelMapper modelMapper;
    protected ObjectMapper objectMapper;

    public void validateParametersExistence(Long countryId, Integer state) throws BusinessException {
        if (countryId == -1 && state != -1) {
            log.debug("validateParametersExistence: can't filter by stat without county: {}, state {} ", countryId,
                    state);
            throw new BusinessException(ErrorCode.ILLEGAL_PARAMS);
        }
    }
}
