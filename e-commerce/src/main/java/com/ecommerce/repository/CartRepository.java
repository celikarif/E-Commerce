package com.ecommerce.repository;

import com.ecommerce.entity.Cart;
import com.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CartRepository extends PagingAndSortingRepository<Cart, Long>, JpaRepository<Cart, Long> {
}
