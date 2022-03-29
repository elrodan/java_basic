package main;

import main.model.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/todo/")
    public List<Todo> list() {
        Iterable<Todo> todoIterable = todoRepository.findAll();
        ArrayList<Todo> todos = new ArrayList<>();
        for (Todo todo : todoIterable) {
            todos.add(todo);
        }
        return todos;
    }

    @PostMapping("/todo/")
    public int add(@RequestBody Todo todo) {
        Todo newTodo = todoRepository.save(todo);
        return newTodo.getId();
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (!optionalTodo.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalTodo.get(), HttpStatus.OK);
    }

    @PutMapping("/todo/{id}")
    public void edit(@PathVariable int id, Todo todo) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isPresent()) {
            todoRepository.save(todo);
        }
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (!optionalTodo.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        todoRepository.deleteById(id);
        return new ResponseEntity(optionalTodo, HttpStatus.OK);
    }

    @DeleteMapping("/todo/")
    public void clearAll() {
        todoRepository.deleteAll();
    }
}
