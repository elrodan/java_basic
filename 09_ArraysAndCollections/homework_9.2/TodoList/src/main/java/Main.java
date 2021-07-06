package main.java;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите команду: ");
            String command = in.nextLine();
            String[] splitCommand = command.split("\s");
            switch (splitCommand[0]) {
                case ("LIST"):
                    for (int i = 0; i < todoList.getSizeList(); i++) {
                        System.out.println(i + " - " + todoList.getTodos().get(i));
                    }
                    break;
                case ("ADD"):
                    if (splitCommand[1].matches("\\d+")) {
                        StringBuilder temp = new StringBuilder();
                        for (int i = 2; i < splitCommand.length; i++) {
                            temp.append(splitCommand[i]).append(" ");
                        }
                        todoList.add(Integer.parseInt(splitCommand[1]), temp.toString());
                    } else {
                        todoList.add(command.substring(command.indexOf(" ")).trim());
                    }
                    break;
                case ("EDIT"):
                    StringBuilder temp = new StringBuilder();
                    for (int i = 2; i < splitCommand.length; i++) {
                        temp.append(splitCommand[i]).append(" ");
                    }
                    if (Integer.parseInt(splitCommand[1]) < splitCommand.length) {
                        todoList.delete(Integer.parseInt(splitCommand[1]));
                        todoList.add(Integer.parseInt(splitCommand[1]), temp.toString());
                    }
                    break;
                case ("DELETE"):
                    todoList.delete(Integer.parseInt(splitCommand[1]));
                    break;
            }
        }
        // TODO: написать консольное приложение для работы со списком дел todoList
    }
}
