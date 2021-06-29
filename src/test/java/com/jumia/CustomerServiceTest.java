package com.jumia;

import com.jumia.enums.ErrorCode;
import com.jumia.exceptions.BusinessException;
import com.jumia.model.Country;
import com.jumia.model.Customer;
import com.jumia.services.api.CustomerService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {

    private static final String TEST_CUSTOMER_NAME = "test customer";
    private static final String TEST_EXTERNAL_ID = "test external";
    public static final Long CUSTOMER_ID = 10l;

    @Autowired
    private CustomerService customerService;

    @Mock
    private Country country;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {
        when(country.getName()).thenReturn(TEST_CUSTOMER_NAME);
    }

    @Test
    public void givenCustomerIdWhenGetCustomerThenReturnCustomer() throws Exception {
        // arrange
        // act
        Customer actual = customerService.getCustomer(CUSTOMER_ID);
        // assert
        assertEquals(CUSTOMER_ID, actual.getId());
    }

    @Test
    public void givenCustomerIdWhenGetCustomerThenThrowBusinessException() throws Exception {
        // arrange
        // act
        exceptionRule.expect(BusinessException.class);
        exceptionRule.expect(new BusinessExceptionCustomMatcher(ErrorCode.NOT_EXIST));
        customerService.getCustomer(100l);
    }

    @Test
    public void givenNothingWhenGetCustomersThenReturnListOfCustomers() throws Exception {
        // arrange
        // act
        List<Customer> actual = customerService.getCustomers();
        // assert
        assertNotNull(actual);
        assertTrue(0 < actual.size());
    }
}
