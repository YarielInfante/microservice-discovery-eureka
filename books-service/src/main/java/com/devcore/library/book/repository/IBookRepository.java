package com.devcore.library.book.repository;

import com.devcore.service.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "book")
public interface IBookRepository extends CrudRepository<Book, Integer> {
}
