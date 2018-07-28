package com.devcore.library.customer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
@Data
public class Customer {

    @Id
    private String id;
    private String email;
    private String name;
    private String last_name;
    @JsonIgnore
    private String password;


    @Override
    public String toString() {
        return "Customer{" +
            "id='" + id + '\'' +
            ", email='" + email + '\'' +
            ", name='" + name + '\'' +
            ", last_name='" + last_name + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}
