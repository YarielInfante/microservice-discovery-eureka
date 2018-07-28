package com.devcore.apigateway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class ReviewDTO {
    private String id;
    private int bookId;
    private String customerId;
    private int stars;
    private String comment;
    private Customer customer;
}
