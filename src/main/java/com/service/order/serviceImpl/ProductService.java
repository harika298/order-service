package com.service.order.serviceImpl;

import com.service.order.dto.CustomerDto;
import com.service.order.dto.ProductDto;
import com.service.order.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    public void insertProduct(ProductDto productDto);

    public ProductDto getProductById(int productId);

    public void updateProduct(ProductDto productDto);

    public void deleteProductById(int productId);

}
