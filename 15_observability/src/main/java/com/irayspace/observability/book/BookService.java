package com.irayspace.observability.book;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book getByIsbn(String isbn) throws Exception {
        final Optional<Book> data = bookRepository.findById(isbn);
        if (data.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "book-not-found");
        }
        return data.get();
    }

}
