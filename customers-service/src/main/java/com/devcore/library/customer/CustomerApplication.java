package com.devcore.library.customer;

import com.devcore.library.customer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class CustomerApplication {

    @RestController
    @RequestMapping("/")
    class Rest {

        @Autowired
        ICustomerRepository customerRepository;

        @GetMapping("/{customerId}")
        @ResponseBody
        ResponseEntity getCustomer(@PathVariable String customerId) {
            System.out.println("customer");
            return ResponseEntity.ok(customerRepository.findById(customerId));

        }
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
