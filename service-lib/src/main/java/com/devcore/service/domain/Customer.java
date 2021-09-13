package com.devcore.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Builder
@AllArgsConstructor
@NoArgsConstructor
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
