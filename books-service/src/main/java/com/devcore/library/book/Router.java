package com.devcore.library.book;

import com.devcore.library.book.service.IBookService;
import com.devcore.service.api.books.BookApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Router implements BookApi {

    public Router(IBookService bookService) {
        this.bookService = bookService;
    }

    private final IBookService bookService;

    @Override
    @GetMapping
    public ResponseEntity getBooks() throws JsonProcessingException {

        System.out.println("books");
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(new ObjectMapper().writeValueAsString(bookService.getAll()));
    }
}
