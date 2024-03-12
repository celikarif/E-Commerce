package com.ecommerce.service;

import com.ecommerce.dto.request.CreateCustomerDto;
import com.ecommerce.dto.response.CustomerDto;

public interface CustomerService {

    void createCustomer(CreateCustomerDto createCustomerDto);

    CustomerDto getCustomerById(Long id );

}
