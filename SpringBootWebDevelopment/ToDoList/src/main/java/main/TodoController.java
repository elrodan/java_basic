package main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import response.Todo;

import java.util.List;

@RestController
public class TodoController {
    @GetMapping("/todo/")
    public List<Todo> list() {
        return Storage.getAllTodo();
    }

    @PostMapping("/todo/")
    public int add(Todo todo) {
        return Storage.addTodo(todo);
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Todo todo = Storage.getTodo(id);
        if (todo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(todo, HttpStatus.OK);
    }

    @PutMapping("/todo/{id}")
    public void edit(@PathVariable int id, Todo todo) {
        Storage.updateTodo(id, todo);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        Todo todo = Storage.getTodo(id);
        if (todo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Storage.deleteTodo(id);
        return new ResponseEntity(todo, HttpStatus.OK);
    }

    @DeleteMapping("/todo/")
    public void clearAll() {
        Storage.clearTodoList();
    }
}
