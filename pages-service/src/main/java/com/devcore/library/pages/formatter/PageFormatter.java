package com.devcore.library.pages.formatter;


import com.devcore.library.pages.domain.Page;
import org.springframework.http.MediaType;

public interface PageFormatter<E> {

    E format(Page page);

    MediaType getMediaType();


}
