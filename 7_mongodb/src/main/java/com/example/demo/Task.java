package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Document("task")
@Getter
@Setter
@RequiredArgsConstructor
public class Task {
    @Id
    private String id;
    private String title;
}
