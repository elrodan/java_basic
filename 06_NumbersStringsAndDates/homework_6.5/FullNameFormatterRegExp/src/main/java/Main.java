package main.java;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      Pattern pattern = Pattern.compile("[а-яА-я]+\\s+[а-яА-я]+\\s+[а-яА-я]+$");
      Matcher matcher = pattern.matcher(input);
      if (matcher.find()) {
        String surname = input.substring(0, input.indexOf(" ")).trim();
        String name = input.substring(input.indexOf(" "), input.lastIndexOf(" ")).trim();
        String patronymic = input.substring(input.lastIndexOf(" ")).trim();
        System.out.println("Фамилия: " + surname + System.lineSeparator() +
                "Имя: " + name + System.lineSeparator() +
                "Отчество: " + patronymic);
      } else {
        System.out.println("Введенная строка не является ФИО");
      }
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
    }
  }

}