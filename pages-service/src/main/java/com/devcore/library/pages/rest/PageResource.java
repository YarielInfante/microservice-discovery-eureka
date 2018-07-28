package com.devcore.library.pages.rest;

import com.devcore.library.pages.domain.Page;
import com.devcore.library.pages.domain.PageDTO;
import com.devcore.library.pages.service.IPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/page")
public class PageResource {

    @Autowired
    private IPageService pageService;



    @GetMapping("/{pageId}/book/{bookId}/{contentType}")
    public ResponseEntity findPageById(@PathVariable("bookId") int bookId, @PathVariable("pageId") int pageId, @PathVariable("contentType") String contentType) {

        Page page = pageService.findByBookIdAndNumber(bookId, pageId);

        if (page != null) {

            PageDTO pageDTO = pageService.formatPage(page, contentType);

            return ResponseEntity.status(HttpStatus.OK).contentType(pageDTO.getMediaType()).body(pageDTO.getContent());

        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Page not found");
    }
}
