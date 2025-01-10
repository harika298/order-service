/*
package com.service.order.repository;

import com.service.order.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "order-service", path = "/product-service")
public interface ProductServiceProxy {

    @GetMapping("/getProductById/{productId}")
    public ProductDto getProductById(@PathVariable("productId") int productId);

    @PutMapping("/updateProduct")
    public void save(@RequestBody ProductDto productDto);
}
*/
