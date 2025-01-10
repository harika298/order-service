package com.service.order.Mappers;

import com.service.order.domain.Product;
import com.service.order.dto.ProductDto;

public class ProductMapper {

    public static ProductDto mapProductEntityToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setCategory(product.getCategory());
        productDto.setProductName(product.getProductName());
        productDto.setUnitPrice(product.getUnitPrice());
        productDto.setDescription(product.getDescription());
        productDto.setQuantity(product.getQuantity());
        return productDto;
    }

    public static Product mapDtoToProductEntity(ProductDto productDto) {
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setCategory(productDto.getCategory());
        product.setProductName(productDto.getProductName());
        product.setUnitPrice(productDto.getUnitPrice());
        product.setDescription(productDto.getDescription());
        product.setQuantity(productDto.getQuantity());
        return product;
    }
}
