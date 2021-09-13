package com.devcore.library.book.service;

import com.devcore.service.domain.Book;

public interface IBookService {

    Iterable<Book> getAll();
}
