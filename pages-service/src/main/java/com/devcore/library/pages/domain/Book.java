package com.devcore.library.pages.domain;


import lombok.Data;

@Data
public class Book {
    private int id;
    private String author;
    private String title;
    private int pages;
    private String coverUrl;
}
