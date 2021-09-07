package com.devcore.library.review.service;



import com.devcore.service.api.reviews.json.ReviewDto;

import java.util.List;

public interface IReviewService {
    List<ReviewDto> getAll();

    List<ReviewDto> getByBookId(int bookId);
}
