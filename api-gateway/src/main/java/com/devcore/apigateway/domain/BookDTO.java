package com.devcore.apigateway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(staticName = "of")
public class BookDTO extends Book {
    private int id;
    private String author;
    private String title;
    private int pages;
    private String coverUrl;
    private List<ReviewDTO> reviews;

}
