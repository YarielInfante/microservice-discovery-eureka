package com.devcore.library.pages.formatter;

import com.devcore.library.pages.domain.Page;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Component("PageFormatHTML")
public class PageFormatHTML implements PageFormatter<String> {

    @Autowired
    private Configuration configuration;

    @Override
    public String format(Page page) {

        configuration.setClassForTemplateLoading(PageFormatHTML.class, "/");
        configuration.setDefaultEncoding("UTF-8");

        Map<String, Object> input = new HashMap<>();
        input.put("title", page.getBook().getTitle());
        input.put("author", page.getBook().getAuthor());
        input.put("content", page.getContent().replace("\n","</br>"));
        input.put("current_page", page.getNumber());

        String output = "";

        try {
            Template template = configuration.getTemplate("templates/page.ftl");


            try (StringWriter out = new StringWriter()) {

                template.process(input, out);
                output = out.getBuffer().toString();

                out.flush();
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;
    }

    @Override
    public MediaType getMediaType() {
        return MediaType.TEXT_HTML;
    }
}
