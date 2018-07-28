package com.devcore.library.customer.repository;

import com.devcore.library.customer.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "customer")
public interface ICustomerRepository extends MongoRepository<Customer, String> {

    Customer findByEmail(@Param("email") String email);
}
