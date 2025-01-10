package com.service.order.serviceImpl;


import com.service.order.Mappers.ProductMapper;
import com.service.order.domain.Product;
import com.service.order.dto.ProductDto;
import com.service.order.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public void insertProduct(ProductDto productDto) {
        productRepo.save(ProductMapper.mapDtoToProductEntity(productDto));
    }

    @Override
    public ProductDto getProductById(int productId) {
       Optional<Product> product = productRepo.findById(productId);
       return ProductMapper.mapProductEntityToDto(product.orElse(new Product()));
    }

    @Override
    public void updateProduct(ProductDto productDto) {
        productRepo.save(ProductMapper.mapDtoToProductEntity(productDto));
    }

    @Override
    public void deleteProductById(int productId) {
        productRepo.deleteById(productId);
    }
}
