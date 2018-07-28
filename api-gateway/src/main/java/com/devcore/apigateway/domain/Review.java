package com.devcore.apigateway.domain;

import lombok.Data;

@Data
public class Review {
    private String id;
    private int bookId;
    private String customerId;
    private int stars;
    private String comment;
}
