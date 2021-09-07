package com.devcore.library.review;

import com.devcore.library.review.service.IReviewService;
import com.devcore.service.api.reviews.ReviewApi;
import com.devcore.service.api.reviews.json.ReviewDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/")
@Slf4j
class Router implements ReviewApi {

    private final IReviewService reviewService;

    public Router(IReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Override
    @GetMapping("/")
    public List<ReviewDto> getAll() {
        return reviewService.getAll();
    }


    @Override
    @GetMapping("/book/{bookId}")
    public List<ReviewDto> getByBookId(@PathVariable int bookId) {
        return reviewService.getByBookId(bookId);
    }

}