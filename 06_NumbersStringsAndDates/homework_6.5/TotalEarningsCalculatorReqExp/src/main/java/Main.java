package main.java;

import java.util.regex.*;

public class Main {

  public static void main(String[] args) {
    System.out.println(calculateSalarySum("Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей"));
  }

  public static int calculateSalarySum(String text){
    Pattern pattern = Pattern.compile("(\\d+)");
    Matcher matcher = pattern.matcher(text);
    Integer totalSum = 0;
    while (matcher.find()) {
      totalSum += Integer.parseInt(matcher.group(1));
    }
    System.out.println(totalSum);
    return totalSum;
  }

}