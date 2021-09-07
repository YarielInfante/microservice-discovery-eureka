package com.devcore.apigateway.web.rest;

import com.devcore.apigateway.domain.*;
import com.devcore.apigateway.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("books")
public class BookResource {


    private final IBookService bookService;
    private final IReviewService reviewService;
    private final ICustomerService customerService;
    private final BookIntegrationService bookIntegrationService;
    private final ReviewIntegrationService reviewIntegrationService;

    @Autowired
    @SuppressWarnings("ALL")
    public BookResource(IBookService bookService,
                        IReviewService reviewService,
                        ICustomerService customerService,
                        BookIntegrationService bookIntegrationService,
                        ReviewIntegrationService reviewIntegrationService) {
        this.bookService = bookService;
        this.reviewService = reviewService;
        this.customerService = customerService;
        this.bookIntegrationService = bookIntegrationService;
        this.reviewIntegrationService = reviewIntegrationService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity getBooks() {


        List<Book> books = bookService.findAll();
        List<BookDTO> bookDTO = new ArrayList<>();
        List<ReviewDTO> reviewDTOS = new ArrayList<>();

        books.forEach(b -> {

            BookDTO dto = BookDTO.of(
                b.getId(),
                b.getAuthor(),
                b.getTitle(),
                b.getPages(),
                b.getCoverUrl(),
                Collections.emptyList());

            List<Review> reviews = reviewService.getByBookId(dto.getId());

            reviews.forEach(r -> reviewDTOS.add(
                ReviewDTO.of(
                    r.getId(),
                    r.getBookId(),
                    r.getCustomerId(),
                    r.getStars(),
                    r.getComment(),
                    customerService.getCustomer(r.getCustomerId())
                )
                )
            );

            dto.setReviews(reviewDTOS);
            bookDTO.add(dto);
        });

        return ResponseEntity.ok(bookDTO);
    }

    @GetMapping("/{bookId}")
    public DeferredResult<ResponseEntity<BookDTO>> getBook(@PathVariable int bookId) {

        DeferredResult<ResponseEntity<BookDTO>> result = new DeferredResult<>();

        Observable.zip(

            bookIntegrationService.getBook(bookId),
            reviewIntegrationService.getReviews(bookId),

            (book, reviews) -> {
                BookDTO dto = BookDTO.of();
                dto.setId(book.getId());
                dto.setAuthor(book.getAuthor());
                dto.setPages(book.getPages());
                dto.setTitle(book.getTitle());
                dto.setReviews(
                    reviews.stream()
                        .map(r -> ReviewDTO.of(r.getId(), r.getBookId(), r.getCustomerId(), r.getStars(), r.getComment(), new Customer()))
                        .collect(Collectors.toList()));

                return dto;
            }
        ).map(ResponseEntity::ok)
            .subscribe(result::setResult);


        return result;
    }


}
