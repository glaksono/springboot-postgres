package com.glcode.simple.service.usecase;

import com.glcode.simple.model.dto.CustomerDto;
import com.glcode.simple.model.entity.Customer;

public interface LoadCustomerData {
    CustomerDto get(String customerId);
}
