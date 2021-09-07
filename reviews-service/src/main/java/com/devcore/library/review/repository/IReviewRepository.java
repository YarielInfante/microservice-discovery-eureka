package com.devcore.library.review.repository;

import com.devcore.service.domain.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "reviews", path = "review")
public interface IReviewRepository extends MongoRepository<Review, String> {

    List<Review> findByBookId(@Param("bookId") int bookId);
}
