package com.ecommerce.mapper.order;

import com.ecommerce.dto.response.OrderDto;
import com.ecommerce.entity.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.Hibernate;

public class MapWithObject {

   public static OrderDto convertToDto(Order order){
       OrderDto orderDto = new OrderDto();

    orderDto.setCustomerName(order.getCustomer().getName());
    orderDto.setOrderNo(order.getOrderNo());
    orderDto.setOrderDate(order.getOrderDate());
    orderDto.setPhoneNumber(order.getCustomer().getPhoneNumber());
    orderDto.setAddress(order.getCustomer().getAddress());
    orderDto.setTotalAmount(order.getTotalAmount());
    orderDto.setProducts(order.getCart().getProducts());
       return orderDto;
    }
}
