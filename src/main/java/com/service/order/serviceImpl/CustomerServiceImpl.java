package com.service.order.serviceImpl;

import com.service.order.Mappers.CustomerMapper;
import com.service.order.domain.Customer;
import com.service.order.dto.CustomerDto;
import com.service.order.repository.CustomerRepo;
import com.service.order.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public void insertCustomer(CustomerDto customerDto) {
        customerRepo.save(CustomerMapper.mapDtoToAddressEntitity(customerDto));
    }

    @Override
    public CustomerDto getCustomerById(int custId) {
        Optional<Customer> customer = customerRepo.findById(custId);
        return CustomerMapper.mapCustomerEntityToDto(customer.orElse(new Customer()));
    }

    @Override
    public boolean checkForDiscount(int custId) {
       Optional<Customer> customer = customerRepo.findById(custId);
       if(customer.isPresent()){
           if(customer.get().getOrderList().size() <= 3){
               return true;
           }
       }
        return false;
    }

    @Override
    public Customer getCustomerMetaDataById(int custId) {
        Optional<Customer> customer = customerRepo.findById(custId);
        return customer.orElse(new Customer());
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
       return customerRepo.findAll().stream()
               .map(CustomerMapper::mapCustomerEntityToDto)
               .collect(Collectors.toList());

//        List<CustomerDto> customerDtoList = new ArrayList<>();
//        for(Customer customer : customerList) {
//          CustomerDto customerDto = CustomerMapper.mapCustomerEntityToDto(customer);
//          customerDtoList.add(customerDto);
//        }
//        return customerDtoList;
    }

    @Override
    public void deleteCustomerById(int custId) {
         customerRepo.deleteById(custId);
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
        customerRepo.save(CustomerMapper.mapDtoToAddressEntitity(customerDto));

    }

}
