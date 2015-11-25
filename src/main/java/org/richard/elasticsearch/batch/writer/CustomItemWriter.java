package org.richard.elasticsearch.batch.writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created on 11/25/2015.
 */
@Component
public class CustomItemWriter implements ItemWriter<String> {
    private static final Logger logger = LoggerFactory.getLogger(CustomItemWriter.class);

    @Override
    public void write(List<? extends String> bookNameWithAuthor) throws Exception {
        //System.out.println(bookNameWithAuthor);
        // logger.debug(bookNameWithAuthor);
        bookNameWithAuthor.stream()
                .forEach(logger::debug);
    }
}
