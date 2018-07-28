package com.devcore.library.pages.service;

import com.devcore.library.pages.domain.Page;
import com.devcore.library.pages.domain.PageDTO;

public interface IPageService {
    Page findByBookIdAndNumber(int bookId, int number);
    PageDTO formatPage(Page page, String formatType);
}
