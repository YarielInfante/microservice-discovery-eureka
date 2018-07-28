package com.devcore.apigateway.service;

import com.devcore.apigateway.domain.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(name = "http://reviews-service")
public interface IReviewService {

    @GetMapping("library/reviews/book/{bookId}")
    @ResponseBody
    List<Review> getByBookId(@PathVariable("bookId") int bookId);
}
