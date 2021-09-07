package com.devcore.library.review.service;

import com.devcore.library.review.repository.IReviewRepository;
import com.devcore.service.api.reviews.json.ReviewDto;
import com.devcore.service.domain.Review;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReviewService implements IReviewService {

    private final IReviewRepository reviewRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public ReviewService(IReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<ReviewDto> getAll() {
        log.debug("getAll");

        List<Review> reviews = reviewRepository.findAll();

        List<ReviewDto> reviewDtos =  modelMapper.map(reviews, new TypeToken<List<ReviewDto>>() {
        }.getType());

        return reviewDtos;
    }

    @Override
    public List<ReviewDto> getByBookId(int bookId){
        System.out.println("getByBookId");
        List<Review> reviews = reviewRepository.findByBookId(bookId);

        List<ReviewDto> reviewDtos =  modelMapper.map(reviews, new TypeToken<List<ReviewDto>>() {
        }.getType());

        return reviewDtos;
    }
}
