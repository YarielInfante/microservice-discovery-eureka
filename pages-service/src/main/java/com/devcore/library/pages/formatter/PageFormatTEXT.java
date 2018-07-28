package com.devcore.library.pages.formatter;


import com.devcore.library.pages.domain.Page;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component("PageFormatTEXT")
public class PageFormatTEXT implements PageFormatter<String> {

    @Value("${application.page.text}")
    private String pageTextFormat;

    @Override
    public String format(Page page) {
        return String.format(pageTextFormat,
                page.getBook().getTitle(), page.getBook().getAuthor(), page.getNumber(), page.getContent());
    }

    @Override
    public MediaType getMediaType() {
        return MediaType.TEXT_PLAIN;
    }
}
