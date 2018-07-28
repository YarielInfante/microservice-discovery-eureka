package com.devcore.library.pages.formatter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PageFormatFactory {

    @Autowired
    @Qualifier("PageFormatHTML")
    private PageFormatter pageFormatterHTML;

    @Autowired
    @Qualifier("PageFormatTEXT")
    private PageFormatter pageFormatterTEXT;

    public PageFormatter getPageFormatter(String format) throws IllegalArgumentException {

        if (format.equalsIgnoreCase("html")) {
            return pageFormatterHTML;
        } else if (format.equalsIgnoreCase("text")) {
            return pageFormatterTEXT;
        } else {
            throw new IllegalArgumentException("no such format: " + format);
        }

    }
}
