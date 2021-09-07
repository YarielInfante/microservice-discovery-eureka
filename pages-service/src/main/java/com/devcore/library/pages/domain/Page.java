package com.devcore.library.pages.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "PAGE")
@Data
public class Page {
    @Id
    private int id;
    private int number;
    private String content;
    private int bookId;
    transient private Book book;
}
