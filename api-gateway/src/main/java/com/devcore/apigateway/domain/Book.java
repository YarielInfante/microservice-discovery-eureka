package com.devcore.apigateway.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Book {
    private int id;
    private String author;
    private String title;
    private int pages;
    private String coverUrl;
}
