package com.devcore.library.review.repository;

import com.devcore.library.review.domain.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "review")
public interface IReviewRepository extends MongoRepository<Review, String> {

    List<Review> findByBookId(@Param("bookId") int bookId);
}
