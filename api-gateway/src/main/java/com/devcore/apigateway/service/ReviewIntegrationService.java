package com.devcore.apigateway.service;

import com.devcore.service.api.reviews.ReviewApi;
import com.devcore.service.api.reviews.json.ReviewDto;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.util.List;

@Service
public class ReviewIntegrationService {


    private final ReviewApi reviewService;

    public ReviewIntegrationService(ReviewApi reviewService) {
        this.reviewService = reviewService;
    }

    public Observable<List<ReviewDto>> getReviews(int bookId) {
        return Observable.fromCallable(() -> reviewService.getByBookId(bookId));
    }
}
