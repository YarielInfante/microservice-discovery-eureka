package com.devcore.apigateway.service;

import com.devcore.apigateway.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.util.List;

@Service
public class ReviewIntegrationService {


    private IReviewService reviewService;

    @SuppressWarnings("ALL")
    public ReviewIntegrationService(@Autowired IReviewService reviewService) {
        this.reviewService = reviewService;
    }

    public Observable<List<Review>> getReviews(int bookId) {
        return Observable.fromCallable(() -> reviewService.getByBookId(bookId));
    }
}
