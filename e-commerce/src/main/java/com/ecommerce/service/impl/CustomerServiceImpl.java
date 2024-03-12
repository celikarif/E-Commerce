package com.ecommerce.service.impl;

import com.ecommerce.dto.request.CreateCustomerDto;
import com.ecommerce.dto.response.CustomerDto;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.Customer;
import com.ecommerce.mapper.MapperService;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.stream.Stream;


@Service
@AllArgsConstructor
public class CustomerServiceImpl  implements CustomerService {

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;
    private MapperService mapperService;

    @Override
    public void createCustomer(CreateCustomerDto createCustomerDto) {
        Customer customer = this.mapperService.forRequest().map(createCustomerDto, Customer.class);
        customer.setCreatedDate(LocalDate.now());

        Cart cart = new Cart();
        cart.setCreatedDate(LocalDate.now());

        this.cartRepository.save(cart);
        customer.setCart(cart);
        this.customerRepository.save(customer);
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = this.customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException ("Customer not found with id: " + id));

        return  this.mapperService.forResponse().map(customer, CustomerDto.class);
    }
}

