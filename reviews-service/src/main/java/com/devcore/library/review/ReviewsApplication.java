package com.devcore.library.review;

import com.devcore.library.review.repository.IReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class ReviewsApplication {

    @RestController
    class Rest {

        @Autowired
        IReviewRepository reviewRepository;

        @GetMapping("/")
        ResponseEntity getAll() {

            System.out.println("/books");
            return ResponseEntity.ok(reviewRepository.findAll());
        }


        @GetMapping("/book/{bookId}")
        ResponseEntity getByBookId(@PathVariable int bookId) {

            System.out.println("/book/" + bookId);
            return ResponseEntity.ok(reviewRepository.findByBookId(bookId));
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(ReviewsApplication.class, args);
    }
}
