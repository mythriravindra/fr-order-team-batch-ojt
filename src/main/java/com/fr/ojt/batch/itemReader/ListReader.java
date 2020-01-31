package com.fr.ojt.batch.itemReader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.Iterator;
import java.util.List;

public class ListReader implements ItemReader<String> {

    private final Iterator<String> data;

    public ListReader(List<String> data) {
        this.data = data.iterator();
    }

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(data.hasNext()) {
            return data.next();
        }
        else {
            return null;
        }
    }
}
