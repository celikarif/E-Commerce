package com.ecommerce.service.impl;

import com.ecommerce.dto.request.CreateProductDto;
import com.ecommerce.dto.request.UpdateProductDto;
import com.ecommerce.dto.response.ProductDto;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Product;
import com.ecommerce.mapper.MapperService;
import com.ecommerce.mapper.product.MapWithObject;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CartRepository cartRepository;
    private CustomerRepository customerRepository;
    private MapperService mapperService;

    @Override
    public void createProduct(CreateProductDto createProductDto) {
        Product product = this.mapperService.forRequest().map(createProductDto, Product.class);
        product.setCreatedDate(LocalDate.now());
        this.productRepository.save(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {

        return this.productRepository.findAll()
                .stream()
                .map(product -> this.mapperService.forResponse().map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));
        return this.mapperService.forResponse().map(product, ProductDto.class);
    }

    @Override
    public void addProductToCard(Long productId , Long customerId) {
       Product product = this.productRepository.findById(productId)
               .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + productId));

       Customer customer= this.customerRepository.findById(customerId)
               .orElseThrow(() -> new IllegalArgumentException("Customer not found with id: " + customerId));

        Cart cart = cartRepository.findById(customer.getCart().getId())
                .orElseThrow(() -> new IllegalArgumentException("Cart not found"));

        List<Product> products = (cart.getProducts() != null && !cart.getProducts().isEmpty()) ? cart.getProducts() : new ArrayList<>();

        double totalAmount = cart.getTotalAmount() != null ? cart.getTotalAmount() : 0.0;

        totalAmount += product.getPrice();

        cart.setTotalAmount(totalAmount);

        products.add(product);
        product.setCart(cart);

        cart.setProducts(products);

        this.cartRepository.save(cart);
        this.productRepository.save(product);

    }
    @Override
    public void removeProductFromCard(Long productId, Long cartId) {

        Product product = this.productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + productId));

        Cart cart = this.cartRepository.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found with id: " + cartId));

        List<Product> productList = cart.getProducts();

        productList.removeIf(pr -> pr.getId().equals(productId));

        cart.setTotalAmount(cart.getTotalAmount() - product.getPrice());

        this.cartRepository.save(cart);

    }

    @Override
    public void deleteProductById(Long productId) {
        this.productRepository.deleteById(productId);
    }

    @Override
    public ProductDto updateProduct(UpdateProductDto updateProductDto) {
        Product product = this.productRepository.findById(updateProductDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: "));

         MapWithObject.convertToEntity(updateProductDto, product);
        this.productRepository.save(product);

        return this.mapperService.forResponse().map(product, ProductDto.class);
    }
}


