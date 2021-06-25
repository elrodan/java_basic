package main.java;

public class Main {

    public static void main(String[] args) {
        System.out.println(searchAndReplaceDiamonds("test <test> test", "123"));
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        while (text.contains("<") && text.contains(">")) {
            String confidentialInfo = text.substring(text.indexOf("<"), text.indexOf(">"));
            text = text.substring(0, text.indexOf("<")) + confidentialInfo.replace(confidentialInfo, placeholder) + text.substring(text.indexOf(">") + 1);
        }
        return text;
    }

}