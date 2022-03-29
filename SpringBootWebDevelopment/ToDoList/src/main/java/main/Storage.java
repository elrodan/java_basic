package main;

import main.model.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {
    private static int currentId = 1;
    private static ConcurrentHashMap<Integer, Todo> todos = new ConcurrentHashMap<Integer, Todo>();

    public static int addTodo(Todo todo) {
        int todoId = currentId++;
        todo.setId(todoId);
        todos.put(todoId, todo);
        return todoId;
    }

    public static List<Todo> getAllTodo() {
        ArrayList<Todo> todoArrayList = new ArrayList<Todo>(todos.values());
        return todoArrayList;
    }

    public static Todo getTodo(int todoId) {
        if (todos.containsKey(todoId)) {
            return todos.get(todoId);
        }
        return null;
    }

    public static void updateTodo(int todoId, Todo todo) {
        todos.replace(todoId, todo);
    }

    public static void deleteTodo(int todoId) {
        currentId--;
        todos.remove(todoId);
    }

    public static void clearTodoList() {
        todos.clear();
    }
}
