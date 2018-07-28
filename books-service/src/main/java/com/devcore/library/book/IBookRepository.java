package com.devcore.library.book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "book")
public interface IBookRepository extends CrudRepository<Book, Integer> {
}
