package com.glcode.simple.controller;

import com.glcode.simple.model.dto.CustomerDto;
import com.glcode.simple.model.dto.DefaultResponseDto;
import com.glcode.simple.service.usecase.CustomerRegistration;
import com.glcode.simple.service.usecase.LoadCustomerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerRegistration customerRegistration;

    @Autowired
    private LoadCustomerData loadCustomerData;

    @GetMapping("/{customer_id}")
    public ResponseEntity get(@PathVariable("customer_id") String customerId){
        return ResponseEntity.ok(DefaultResponseDto.create(loadCustomerData.get(customerId)));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CustomerDto customerDto){
        DefaultResponseDto data = DefaultResponseDto.create(customerRegistration.register(customerDto));
        return ResponseEntity.ok(data);
    }



}
