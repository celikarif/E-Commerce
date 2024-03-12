package com.ecommerce.service.impl;

import com.ecommerce.dto.response.OrderDto;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Order;
import com.ecommerce.mapper.order.MapWithObject;
import com.ecommerce.mapper.MapperService;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {


    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private CartRepository cartRepository;
    private MapperService mapperService;


    @Override
    public OrderDto placeOrder(Long customerId) {
        Order order = new Order();

        OrderDto orderDto = new OrderDto();

        Customer customer= this.customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with id: " + customerId));
        try {

            Cart cart = customer.getCart();

            order.setCart(cart);
            order.setCustomer(customer);

            order.setTotalAmount(cart.getTotalAmount());
            order.setOrderDate(LocalDate.now());

            String code = UUID.randomUUID().toString();
            order.setCode(code);

            String no = String.valueOf((int) (Math.random() * 900000) + 100000);
            order.setOrderNo(no);

            orderRepository.save(order);

            cart.getProducts().forEach(product -> product.setStock(product.getStock() - 1));

            cart.setTotalAmount(0.0);

            cart.setModifiedDate(LocalDate.now());

            List<Order> orders = (cart.getOrders() != null && !cart.getOrders().isEmpty()) ? cart.getOrders() : new ArrayList<>();
            orders.add(order);
            cart.setOrders(orders);

            orderDto = MapWithObject.convertToDto(order);

             cart.setProducts(new ArrayList<>());
              cartRepository.save(cart);

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return orderDto;
    }

    @Override
    public OrderDto getOrderForCode(String code) {
        Order order = this.orderRepository.findByCode(code);

        return MapWithObject.convertToDto(order);

    }
    @Override
    public OrderDto getOrderForOrderNo(String no) {
        Order order = this.orderRepository.findByOrderNo(no);

        return MapWithObject.convertToDto(order);
    }

    @Override
    public List<OrderDto> getAllOrdersForCustomer(Long customerId) {
        Customer customer= this.customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with id: " + customerId));
        List<Order> orders = this.orderRepository.findByCustomer(customer);

        return orders.stream()
                .map(order -> MapWithObject.convertToDto(order))
                .collect(Collectors.toList());

    }
}
