package com.service.order.dto;

import lombok.Data;

@Data
public class ProductDto {

    private int productId;
    private String category;
    private String productName;
    private double unitPrice;
    private String description;
    private int quantity;
}
