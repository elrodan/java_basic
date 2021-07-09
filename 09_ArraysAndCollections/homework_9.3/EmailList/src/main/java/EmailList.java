package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    TreeSet<String> emailList = new TreeSet<>();

    public void add(String email) {
        Pattern pattern = Pattern.compile("\\w+@\\w+\\.(ru|com)");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            emailList.add(email.toLowerCase(Locale.ROOT));
        } else {
            System.out.println(WRONG_EMAIL_ANSWER);
        }
    }

    public List<String> getSortedEmails() {
        ArrayList<String> emailListFinal = new ArrayList<>(emailList);
        return emailListFinal;
    }

}
