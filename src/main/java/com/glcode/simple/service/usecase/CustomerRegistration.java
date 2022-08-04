package com.glcode.simple.service.usecase;

import com.glcode.simple.model.dto.CustomerDto;

public interface CustomerRegistration {
    String register(CustomerDto customer);
}
