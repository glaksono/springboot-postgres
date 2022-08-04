package com.glcode.simple.service;

import com.glcode.simple.model.dto.CustomerDto;
import com.glcode.simple.model.entity.Customer;
import com.glcode.simple.repository.CustomerRepository;
import com.glcode.simple.service.usecase.CustomerRegistration;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class SimpleCustomerRegistration implements CustomerRegistration {
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    public SimpleCustomerRegistration(@Autowired CustomerRepository customerRepository, @Autowired ModelMapper modelMapper){
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String register(CustomerDto newCustomer) {
        Customer customer = modelMapper.map(newCustomer, Customer.class);
        customer.setUniqueId(UUID.randomUUID().toString());
        customerRepository.save(customer);
        return customer.getUniqueId();
    }
}
