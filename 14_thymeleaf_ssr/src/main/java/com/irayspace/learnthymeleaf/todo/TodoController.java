package com.irayspace.learnthymeleaf.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("todos", todoService.getAll());
        model.addAttribute("todo", new Todo());
        return "index";
    }

    @PostMapping("/create")
    public String createTodo(@ModelAttribute("todo") Todo todo) {
        todoService.create(todo);
        return "redirect:/";
    }

    @GetMapping("/done/{name}")
    public String setDone(@PathVariable("name") String name) {
        todoService.doneByName(name);
        return "redirect:/";
    }

    @GetMapping("/remove/{name}")
    public String removeByName(@PathVariable("name") String name) {
        todoService.removeByName(name);
        return "redirect:/";
    }
}
