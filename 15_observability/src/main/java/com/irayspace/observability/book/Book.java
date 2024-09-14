package com.irayspace.observability.book;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Book {
    private String title;
    private String genre;
    private String author;
    private String description;
}
