package com.devcore.service.api.reviews;


import com.devcore.service.api.reviews.json.ReviewDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("http://reviews-service")
public interface ReviewApi {
    @GetMapping("/")
    List<ReviewDto> getAll();

    @GetMapping("/library/reviews/book/{bookId}")
    List<ReviewDto> getByBookId(@PathVariable int bookId);
}
