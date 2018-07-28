package com.devcore.apigateway.service;


import com.devcore.apigateway.domain.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@FeignClient("http://books-service")
public interface IBookService {

    @GetMapping("/library/books/book/{bookId}")
    Book findBookById(@PathVariable("bookId") int bookId);

    @GetMapping("/library/books")
    @ResponseBody
    List<Book> findAll();
}
