package com.devcore.library.pages.repository;

import com.devcore.library.pages.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPageRepository extends PagingAndSortingRepository<Page, Integer> {

    Page findByBookIdAndNumber(int bookId, int number);
}
