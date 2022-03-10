package com.example.demo.controller;

import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;
    private final Logger logger = LoggerFactory.getLogger(TodoController.class);

    //POST
    @PostMapping("/todo")
    public Todo addTodo(@RequestBody Todo todo) {
        logger.info("Todo object {}", todo.toString());
        return todoService.saveTodo(todo);
    }

    //GET
    @GetMapping("/todo")
    public List<Todo> getAllTodo() {
        return todoService.getTodos();
    }

    // GET
    @GetMapping("/todo/{id}")
    public Todo findTodoById(@PathVariable int id) {
        return todoService.getTodoById(id);
    }

    //PUT
    @PutMapping("/todo/{id}")
    public Todo updateCourse(@PathVariable int id, @RequestBody Todo todo)
    {
        System.out.println("UPDATED");
        return todoService.updateTodo(id, todo);
    }

    //DELETE
    @DeleteMapping("/todo/{id}")
    public String deleteCourse(@PathVariable int id) {
        return todoService.deleteTodo(id);
    }
}
