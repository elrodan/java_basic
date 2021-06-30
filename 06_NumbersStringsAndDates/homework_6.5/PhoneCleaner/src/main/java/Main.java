package main.java;

import java.util.Scanner;
import java.util.regex.*;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      String clearPhone = input.replaceAll("[\\D]", "");
      Pattern pattern = Pattern.compile("^[789][\\d+]{9}$|^[78][\\d+]{10}$");
      Matcher matcher = pattern.matcher(clearPhone);
      if (matcher.find()) {
        System.out.println(clearPhone.replaceAll("^[8][9]|^[9]", "79"));
      } else {
        System.out.println("Неверный формат номера");
      }

    }
  }

}
