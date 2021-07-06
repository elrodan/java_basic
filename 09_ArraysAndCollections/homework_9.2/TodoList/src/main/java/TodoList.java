package main.java;

import java.util.ArrayList;

public class TodoList {

    ArrayList<String> todoList = new ArrayList<>();

    public void add(String todo) {
        todoList.add(todo);
    }

    public void add(int index, String todo) {
        if (index > todoList.size()) {
            todoList.add(todo);
        } else {
            todoList.add(index, todo);
        }
    }

    public void edit(String todo, int index) {
        if (index >= todoList.size()) {
            System.out.println("Такого номера дела нет");
        } else {
            todoList.remove(index);
            todoList.add(index, todo);
        }
    }

    public void delete(int index) {
        if (index >= todoList.size()) {
            System.out.println("Такого номера дела нет");
        } else {
            todoList.remove(index);
        }
    }

    public int getSizeList() {
        return todoList.size();
    }

    public ArrayList<String> getTodos() {
        return todoList;
    }

}