package com.devcore.apigateway.domain;

import lombok.Data;


@Data
public class Page {
    private int id;
    private int number;
    private String content;
    private int bookId;
    transient private Book book;
}
