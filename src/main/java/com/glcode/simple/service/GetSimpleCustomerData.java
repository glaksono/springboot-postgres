package com.glcode.simple.service;

import com.glcode.simple.model.dto.CustomerDto;
import com.glcode.simple.model.entity.Customer;
import com.glcode.simple.repository.CustomerRepository;
import com.glcode.simple.service.usecase.LoadCustomerData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetSimpleCustomerData implements LoadCustomerData {
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    public GetSimpleCustomerData(@Autowired CustomerRepository customerRepository,
                                 @Autowired ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public CustomerDto get(String customerId) {
        Optional<Customer> data = customerRepository.findByUniqueId(customerId);
        if(data.isPresent()){
            return modelMapper.map(data, CustomerDto.class);
        }
        return null;
    }
}
