package com.devcore.library.modulex.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Data
public class Review {
    @Id
    private String id;
    private int bookId;
    private String customerId;
    private int stars;
    private String comment;
}
