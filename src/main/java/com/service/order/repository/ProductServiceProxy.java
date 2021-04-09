package com.service.order.repository;

import com.service.order.domain.ProductType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="product-service")
public interface ProductServiceProxy {

    @RequestMapping("/getProductType/{id}")
    public ProductType findProductById(int id);
}
