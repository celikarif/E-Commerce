package com.ecommerce.controller;

import com.ecommerce.dto.request.CreateProductDto;
import com.ecommerce.dto.request.UpdateProductDto;
import com.ecommerce.dto.response.ProductDto;
import com.ecommerce.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
@NoArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public void createProduct(@RequestBody CreateProductDto createProductDto){
    this.productService.createProduct(createProductDto);
    }

    @GetMapping
    public ProductDto getProductDtoById(@RequestParam("id") Long id){
      return this.productService.getProductById(id);

    }
    @GetMapping("/getAll")
    public List<ProductDto> getAllProducts(){
       return this.productService.getAllProducts();
    }

    @PostMapping("/add")
    public void addProductToCard(@RequestParam("productId") Long productId, @RequestParam("customerId") Long customerId) {
        this.productService.addProductToCard(productId, customerId);
    }

    @PostMapping("/remove")
    public void removeProductFromCard (@RequestParam("productId") Long productId, @RequestParam("cartId") Long cartId) {
        this.productService.removeProductFromCard(productId , cartId);
    }

    @DeleteMapping
    public void deleteProductById(@RequestParam("productId") Long productId){
        this.productService.deleteProductById(productId);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody UpdateProductDto updateProductDto ){
        return this.productService.updateProduct(updateProductDto);
    }

}
