package main.java;

public class Main {

    public static void main(String[] args) {

    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        text = text.replaceAll("(\\<[\\w\\s]+\\>)", placeholder);
        return text;
    }

}