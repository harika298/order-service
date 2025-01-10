package com.service.order.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private int productId;
    private String category;
    private String productName;
    private double unitPrice;
    private String description;
    private int quantity;

    @ManyToMany(mappedBy = "orderedProducts")
    Set<Order> orders;

    public Product() {
    }

    public Product(int productId, String category, String productName, double unitPrice, String description, int quantity, Set<Order> orders) {
        this.productId = productId;
        this.category = category;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.description = description;
        this.quantity = quantity;
        this.orders = orders;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", category='" + category + '\'' +
                ", productName='" + productName + '\'' +
                ", unitPrice=" + unitPrice +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
