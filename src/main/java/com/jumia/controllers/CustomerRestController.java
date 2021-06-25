package com.jumia.controllers;

import com.jumia.exceptions.BusinessException;
import com.jumia.facade.api.CustomerFacade;
import com.jumia.model.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@Slf4j
@RestController
@RequestMapping(CustomerRestController.ENDPOINT)
@Api(produces = MediaType.APPLICATION_JSON_VALUE, tags = "Customer")
public class CustomerRestController {

    private static final String OP_GET_A_CUSTOMER = "Get a Customer";
    private static final String OP_GET_A_CUSTOMERS = "Get Customers";
    public static final String ENDPOINT = "/api/v2/customers";


    @Autowired
    private CustomerFacade customerFacade;

    @ApiOperation(OP_GET_A_CUSTOMER)
    @GetMapping("/{id}")
    public Customer getCustomer(
            @ApiParam(name = "ID", required = true) @PathVariable("id") Long customerId)
            throws BusinessException {
        log.debug("getCustomer: get customer request for customer id: {} ", customerId);

        return customerFacade.getCustomer(customerId);
    }

    @ApiOperation(OP_GET_A_CUSTOMERS)
    @GetMapping("/country/{countryId}/state/{state}")
    public ResponseEntity<?> getCustomers(@ApiParam(name = "CountryId", required = true) @PathVariable("countryId") Long countryId,
                                          @ApiParam(name = "State", required = true) @PathVariable("state") Integer state) throws BusinessException {
        log.debug("getCustomers: get customers request for customer countryId: {}, state {} ", countryId, state);
        return ResponseEntity.status(HttpStatus.OK).body(customerFacade.getCustomers(countryId, state));
    }
}
