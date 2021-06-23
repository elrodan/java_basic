package main.java;

public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    String str = text.trim();
    int totalCost = 0;
    String cutString = "";
    for (int i = 0; i < str.length(); i++) {
      char chars = str.charAt(i);
      if (Character.isDigit(chars)) {
        cutString = cutString + chars;
      } else {
        if (cutString != "") {
          totalCost += Integer.parseInt(cutString);
        }
        cutString = "";
      }
    }
    System.out.println(totalCost);
  }

}