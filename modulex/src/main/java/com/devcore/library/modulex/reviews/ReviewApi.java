package com.devcore.library.modulex.reviews;


import com.devcore.library.modulex.reviews.json.ReviewDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "http://reviews-service")
public interface ReviewApi {
    @GetMapping("/")
    List<ReviewDto> getAll();

    @GetMapping("/book/{bookId}")
    List<ReviewDto> getByBookId(@PathVariable int bookId);
}
