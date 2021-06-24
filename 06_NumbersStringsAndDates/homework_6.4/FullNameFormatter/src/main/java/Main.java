package main.java;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      int spaceCount = 0;
      boolean useNumber = false;
      if (input.equals("0")) {
        break;
      }
      for (int i = 0; i < input.length(); i++) {
        char chars = input.charAt(i);
        if (Character.isDigit(chars)) {
          useNumber = true;
        }
        if (String.valueOf(input.charAt(i)).equals(" ")) {
          spaceCount += 1;
        }
      }
      if (spaceCount == 2 && !useNumber) {
        String surname = input.substring(0, input.indexOf(" ")).trim();
        String name = input.substring(input.indexOf(" "), input.lastIndexOf(" ")).trim();
        String patronymic = input.substring(input.lastIndexOf(" ")).trim();
        System.out.println("Фамилия: " + surname + System.lineSeparator() +
                "Имя: " + name + System.lineSeparator() +
                "Отчество: " + patronymic);
      } else {
        System.out.println("Введенная строка не является ФИО");
      }
    }
  }

}