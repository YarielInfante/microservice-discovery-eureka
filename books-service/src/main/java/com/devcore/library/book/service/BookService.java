package com.devcore.library.book.service;

import com.devcore.library.book.repository.IBookRepository;
import com.devcore.service.domain.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService implements com.devcore.library.book.service.IBookService {

    private IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> getAll() {
        return bookRepository.findAll();
    }


}
