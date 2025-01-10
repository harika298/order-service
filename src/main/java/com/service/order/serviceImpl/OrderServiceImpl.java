package com.service.order.serviceImpl;

import com.service.order.Mappers.ProductMapper;
import com.service.order.domain.Order;
import com.service.order.domain.Product;
import com.service.order.dto.ProductDto;
import com.service.order.exception.ProductNotFoundException;
import com.service.order.repository.OrderRepo;
import com.service.order.repository.ProductRepo;
//import com.service.order.repository.ProductServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class OrderServiceImpl {
    @Autowired
    OrderRepo repo;

    /*@Autowired
    ProductServiceProxy productServiceProxy;*/

    @Autowired
    WebClient webClient;

    @Autowired
    ProductRepo productRepo;

    public void insertOrder(Order order) throws ProductNotFoundException {

        List<Product> products = order.getOrderedProducts();
        List<Order> list = new ArrayList();
        int lastOrderId = repo.findLatestOrderById();

        for (Product product : products) {
            int productId = product.getProductId();
            Optional<Product> productDataById = productRepo.findById(productId);
            if (productDataById.isPresent()) {
                try {
                    //using resttemplate check for discount
                    //if true then update the actual, discount and total price based on 10% discount and save the order.
                    Boolean hasDiscount = webClient.get().uri("/checkForDiscount/" +
                                    order.getCustomer().getCustId())
                            .retrieve().bodyToMono(Boolean.class).block();
                    if (Boolean.TRUE.equals(hasDiscount)) {
                        float actualPriceResult =
                                Float.parseFloat(String.valueOf(product.getQuantity() * product.getUnitPrice()));
                        order.setActualPrice(actualPriceResult);
                        order.setDiscountPrice(actualPriceResult * 0.1f);
                        order.setTotalOrderPrice(actualPriceResult - order.getDiscountPrice());
                    }
                    int diff = productDataById.get().getQuantity() - product.getQuantity();
                    productDataById.get().setQuantity(diff);
//                    productServiceProxy.save(ProductMapper.mapProductEntityToDto(productDataById.get()));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            order.setOrderId(lastOrderId+1);
            lastOrderId++;
            list.add(order);
        }


        List<Order> order1 = repo.saveAll(list);

        for (Order orderResult : order1) {
            if (orderResult != null && orderResult.getOrderId() != 0) {
                /**/

            } else {
//                throw new ProductNotFoundException("order is not inserted because " + productId + " is not found");
            }
        }
    }
}
