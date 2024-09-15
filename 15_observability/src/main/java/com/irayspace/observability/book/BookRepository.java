package com.irayspace.observability.book;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.irayspace.observability.annotation.ScopedSpan;


@Component
public class BookRepository {
   
    private Map<String, Book> books = new HashMap<>(){{
        put("0486415872", new Book("Crime and Punishment", "Philosophical Fiction", "Fyodor Dostoyevsky", ""));
    }};

    @ScopedSpan("BookRepository.findById")
    public Optional<Book> findById(String id) {
        try {
            Thread.sleep(2100);
        } catch (InterruptedException e) {
            // Nothing is in here
        }
        return Optional.ofNullable(books.get(id));
    }

}
