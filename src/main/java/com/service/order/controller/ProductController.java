package com.service.order.controller;

import com.service.order.dto.ProductDto;
import com.service.order.serviceImpl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product-service")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(path = "/insertProduct", consumes = "application/json")
    public void insertProduct(@RequestBody ProductDto productDto) {
        productService.insertProduct(productDto);
    }
    @GetMapping(path = "/getProductById/{productId}", produces = "application/json")
    public ProductDto getProductById(@PathVariable int productId){
        return productService.getProductById(productId);
    }
    @DeleteMapping(path = "/deleteProductById/{productId}")
    public HttpStatus deleteProductById(@PathVariable int productId) {
        productService.deleteProductById(productId);
        return HttpStatus.OK;
    }
    @PutMapping(path = "/updateProduct", consumes = "application/json")
    public void updateProduct(@RequestBody ProductDto productDto) {
        productService.updateProduct(productDto);

    }

}
