package com.ecommerce.repository;

import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long>, JpaRepository<Order, Long> {
    Order findByCode(String code);

    Order findByOrderNo(String no);

    List<Order> findByCustomer (Customer customer);
 }
