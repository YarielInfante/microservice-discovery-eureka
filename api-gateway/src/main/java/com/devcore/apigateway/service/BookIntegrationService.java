package com.devcore.apigateway.service;

import com.devcore.apigateway.domain.Book;
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

    public Observable<Book> getBook(int bookId) {
        return Observable.fromCallable(() -> bookService.findBookById(bookId));
    }
}
