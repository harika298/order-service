package com.service.order.serviceImpl;

import com.service.order.domain.Customer;
import com.service.order.dto.CustomerDto;
import com.service.order.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {


    public void insertCustomer(CustomerDto customerDto);

    public CustomerDto getCustomerById(int custId);

    public boolean checkForDiscount(int custId);

    public Customer getCustomerMetaDataById(int custId );

    public List<CustomerDto> getAllCustomers();

    public void deleteCustomerById(int custId) ;

    public void updateCustomer(CustomerDto customerDto);

}
