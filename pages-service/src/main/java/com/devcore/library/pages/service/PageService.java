package com.devcore.library.pages.service;

import com.devcore.library.pages.domain.Page;
import com.devcore.library.pages.domain.PageDTO;
import com.devcore.library.pages.formatter.PageFormatFactory;
import com.devcore.library.pages.formatter.PageFormatter;
import com.devcore.library.pages.repository.IBookService;
import com.devcore.library.pages.repository.IPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;


@Service
public class PageService implements IPageService {


    @Autowired
    private PageFormatFactory pageFormatFactory;

    @Autowired
    private IPageRepository pageDao;

    @Autowired
    @SuppressWarnings("ALL")
    private IBookService bookService;


    @Override
    public Page findByBookIdAndNumber(int bookId, int number) {
        return pageDao.findByBookIdAndNumber(bookId, number);
    }

    @Override
    public PageDTO formatPage(Page page, String formatType) {

        page.setBook(bookService.findBookById(page.getBookId()));

        PageFormatter pageFormatter = pageFormatFactory.getPageFormatter(formatType);

        Object format =  pageFormatter.format(page);
        MediaType mediaType = pageFormatter.getMediaType();

        return new PageDTO(format, mediaType);
    }


}
