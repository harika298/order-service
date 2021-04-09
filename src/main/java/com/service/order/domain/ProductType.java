package com.service.order.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductType implements Serializable {

    @Id
    private int productTypeId;
    private String productType;
    private String productTypeDescription;


    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductTypeDescription() {
        return productTypeDescription;
    }

    public void setProductTypeDescription(String productTypeDescription) {
        this.productTypeDescription = productTypeDescription;
    }

   /* public List<Products> getProductsList() {
        return productsList;
    }
*/
    public ProductType() {
    }

    public ProductType(int productTypeId, String productType, String productTypeDescription/*, List<Products> productsList*/) {
        this.productTypeId = productTypeId;
        this.productType = productType;
        this.productTypeDescription = productTypeDescription;
//        this.productsList = productsList;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "productTypeId=" + productTypeId +
                ", productType='" + productType + '\'' +
                ", productTypeDescription='" + productTypeDescription + '\'' +
                '}';
    }

//    public void setProductsList(List<Products> productsList) {
//        this.productsList = productsList;
//    }
}