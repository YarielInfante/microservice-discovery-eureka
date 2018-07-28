package com.devcore.apigateway.service;

import com.devcore.apigateway.domain.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.util.List;

@Service
public class BookIntegrationService {

    @Autowired
    private IBookService bookService;

    public Observable<List<Book>> getBooks() {
        return Observable.fromCallable(() -> bookService.findAll());
    }

    @HystrixCommand(fallbackMethod = "getBookFallBack")
    public Observable<Book> getBook(int bookId) {
        return Observable.fromCallable(() -> bookService.findBookById(bookId));
    }


    public Observable<Book> getBookFallBack(int bookId) {
        return Observable.just(Book.of(1, "Oracle", "Java ee 6", 50, ""));
    }
}
