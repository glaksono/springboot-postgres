package com.glcode.simple.config;

import com.glcode.simple.model.dto.CustomerDto;
import com.glcode.simple.service.GetSimpleCustomerData;
import com.glcode.simple.service.SimpleCustomerRegistration;
import com.glcode.simple.service.usecase.CustomerRegistration;
import com.glcode.simple.service.usecase.LoadCustomerData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {DatasourceConfig.class, CustomBeanConfig.class})
@Import({GetSimpleCustomerData.class, SimpleCustomerRegistration.class})
@EnableJpaRepositories(basePackages = {"com.glcode.simple.repository"})
@TestPropertySource(locations = {"classpath:application.properties"})
@Transactional
public class CustomerFunctionalTest {

    @Autowired
    LoadCustomerData loadCustomerData;

    @Autowired
    CustomerRegistration customerRegistration;

    @Test
    public void test_load(){
        CustomerDto data = loadCustomerData.get("b0a7c5f0-238b-49b6-904b-248dbe792915");
        System.out.println(data);
    }

    @Test
    @Rollback(value = false)
    public void test_create(){
        CustomerDto newCustomer = new CustomerDto();
        newCustomer.setAddress("Home Main Road 123333");
        newCustomer.setEmail("myEmail@email.com");
        newCustomer.setName("Customer Nameaaa");
        newCustomer.setLastName("Lastname1234");
        customerRegistration.register(newCustomer);
    }
}
