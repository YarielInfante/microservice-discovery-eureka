package com.devcore.apigateway.service;

import com.devcore.apigateway.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

@Service
public class CustomerIntegrationService {

    private ICustomerService customerService;


    @SuppressWarnings("ALL")
    public CustomerIntegrationService(@Autowired ICustomerService customerService) {
        this.customerService = customerService;
    }

    public Observable<Customer> getCustomer(String customerId) {
        return Observable.fromCallable(() -> customerService.getCustomer(customerId));
    }
}
