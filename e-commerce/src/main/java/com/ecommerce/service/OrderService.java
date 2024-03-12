package com.ecommerce.service;

import com.ecommerce.dto.response.OrderDto;
import com.ecommerce.entity.Order;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface OrderService {

    OrderDto placeOrder(Long cartId);
    OrderDto getOrderForCode(String code);
    OrderDto getOrderForOrderNo(String no);
    List<OrderDto> getAllOrdersForCustomer(Long customerId);

}