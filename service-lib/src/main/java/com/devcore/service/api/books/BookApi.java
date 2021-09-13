package com.devcore.service.api.books;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface BookApi {
    @GetMapping
    ResponseEntity getBooks() throws JsonProcessingException;
}
