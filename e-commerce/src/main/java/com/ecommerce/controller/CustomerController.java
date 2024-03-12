package com.ecommerce.controller;


import com.ecommerce.dto.request.CreateCustomerDto;
import com.ecommerce.dto.response.CustomerDto;
import com.ecommerce.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public void createCustomer(@RequestBody  CreateCustomerDto createCustomerDto) {
        this.customerService.createCustomer(createCustomerDto);
    }
    @GetMapping
    public CustomerDto getCustomerById(@RequestParam("id") Long id) {
        return this.customerService.getCustomerById(id);
    }
}
