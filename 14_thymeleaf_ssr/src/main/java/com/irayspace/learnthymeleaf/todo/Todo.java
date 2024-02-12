package com.irayspace.learnthymeleaf.todo;

import lombok.Data;

@Data
public class Todo {
    private String name;
    private boolean done = false;

    public Todo() {}
    public Todo(String name) {
        this.name = name;
    }
}
