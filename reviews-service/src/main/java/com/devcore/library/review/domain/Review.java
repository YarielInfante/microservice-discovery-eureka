package com.devcore.library.review.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Review {
    @Id
    private String id;
    private int bookId;
    private String customerId;
    private int stars;
    private String comment;
}
