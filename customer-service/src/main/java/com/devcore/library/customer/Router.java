package com.devcore.library.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Router {

    @GetMapping
    @ResponseBody
    public String getCustomer() {
        System.out.println("customer");
        return "hello";
    }
}
