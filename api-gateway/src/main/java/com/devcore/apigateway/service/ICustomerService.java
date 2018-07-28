package com.devcore.apigateway.service;

import com.devcore.apigateway.domain.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "http://customer-service")
public interface ICustomerService {

    @GetMapping("/library/customers/{customerId}")
    Customer getCustomer(@PathVariable("customerId") String customerId);
}
