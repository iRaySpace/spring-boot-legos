package com.irayspace.learnthymeleaf.todo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private List<Todo> todos = new LinkedList<Todo>(
        // Arrays.asList(new Todo("Learn Thymeleaf"))
    );

    public List<Todo> getAll() {
        return todos;        
    }

    public void create(Todo todo) {
        boolean exists = todos.stream().anyMatch(existingTodo -> existingTodo.getName().contentEquals(todo.getName()));
        if (!exists) {
            todos.add(todo);
        }
    }

    public void doneByName(String name) {
        for (Todo todo : todos) {
            if (todo.getName().contentEquals(name)) {
                todo.setDone(true);
            }
        }
    }

    public void removeByName(String name) {
        todos = todos.stream().filter(todo -> !todo.getName().contentEquals(name)).collect(Collectors.toList());
    }
}
