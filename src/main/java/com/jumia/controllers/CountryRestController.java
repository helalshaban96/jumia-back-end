package com.jumia.controllers;

import com.jumia.exceptions.BusinessException;
import com.jumia.services.api.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@Slf4j
@RestController
@RequestMapping(CountryRestController.ENDPOINT)
@Api(produces = MediaType.APPLICATION_JSON_VALUE, tags = "Country")
public class CountryRestController {

    private static final String OP_GET_A_COUNTRIES = "Get Countries";

    public static final String ENDPOINT = "/api/v2/countries";

    @Autowired
    private CountryService countryService;

    @ApiOperation(OP_GET_A_COUNTRIES)
    @GetMapping
    public ResponseEntity<?> getCountries() throws BusinessException {
        log.debug("getCountries: get countries request");
        return ResponseEntity.status(HttpStatus.OK).body(countryService.getCountries());
    }
}
