package com.devcore.library.book;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class BookApplication {

    @RestController
    @RequestMapping("/")
    class Rest {
        @Autowired
        IBookRepository bookRepository;

        @GetMapping
        public ResponseEntity getBooks() throws JsonProcessingException {
            Iterable<Book> all = bookRepository.findAll();

            System.out.println("books");
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(new ObjectMapper().writeValueAsString(all));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }
}
