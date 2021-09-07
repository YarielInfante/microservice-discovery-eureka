package com.devcore.library.modulex.reviews.json;

import lombok.Data;

@Data
public class ReviewDto {
    private String id;
    private int bookId;
    private String customerId;
    private int stars;
    private String comment;
}
