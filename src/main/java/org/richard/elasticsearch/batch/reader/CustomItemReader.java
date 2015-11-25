package org.richard.elasticsearch.batch.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.List;

/**
 * Created on 11/25/2015.
 */
public class CustomItemReader implements ItemReader<String> {
    private List<String> bookNameList;
    private int bookCount = 0;


    public List<String> getUserNameList() {
        return bookNameList;
    }
    public void setBookNameList(List<String> bookNameList) {
        this.bookNameList = bookNameList;
    }

    @Override
    public String read() throws Exception {
        if (bookCount < bookNameList.size()) {
            return bookNameList.get(bookCount++);
        } else {
            return null;
        }
    }
}
