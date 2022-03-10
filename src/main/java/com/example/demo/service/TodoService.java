package com.example.demo.service;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    //POST
    public Todo saveTodo(Todo todo) {
        System.out.println(todo.toString());
        return todoRepository.save(todo);
    }

    //Optional!
    public List<Todo> saveTodos(List<Todo> todos) {
        return todoRepository.saveAll(todos);
    }

    //GET
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }
    public Todo getTodoById(int id) {
        return todoRepository.findById(id).orElse(null);
    }

    public Todo getTodoByName(String name) {
        return todoRepository.findByName(name);
    }

    //PUT
    public Todo updateTodo(int id, Todo todo) {
        System.out.println("updates");
        Todo oldTodo = todoRepository.findById(todo.getId()).orElse(null);
        oldTodo.setName(todo.getName());
        return todoRepository.save(oldTodo);
    }

    //DELETE
    public String deleteTodo(int id) {
        todoRepository.deleteById(id);
        return id + " id -> course removed/completed";
    }
}
