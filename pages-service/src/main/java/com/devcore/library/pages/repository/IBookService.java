package com.devcore.library.pages.repository;

import com.devcore.library.pages.domain.Book;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "books-service")
@RibbonClient(name = "books-service")
public interface IBookService {

    @GetMapping("/library/books/book/{bookId}")
    Book findBookById(@PathVariable("bookId") int bookId);

}
