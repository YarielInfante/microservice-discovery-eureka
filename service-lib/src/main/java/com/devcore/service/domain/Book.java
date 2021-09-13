package com.devcore.service.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "BOOK")
@Data
public class Book {
    @Id
    private int id;
    private String author;
    private String title;
    private int pages;
    private String coverUrl;
}
