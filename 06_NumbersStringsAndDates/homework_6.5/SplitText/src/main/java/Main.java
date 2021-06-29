package main.java;

public class Main {

  public static void main(String[] args) {
    System.out.println(splitTextIntoWords("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
  }

  public static String splitTextIntoWords(String text) {
    String firstIteration = text.replaceAll("[\\W+\\s+]","\n").trim();
    String secondIteration = firstIteration.replaceAll("(\\n{2,})", "\n");

    return secondIteration;
  }

}