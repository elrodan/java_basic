package main.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmailList listEmail = new EmailList();
        
        while (true) {
            String input = scanner.nextLine();
            String[] splitCommand = input.split("\\s", 2);
            if (input.equals("0")) {
                break;
            }
            switch (splitCommand[0]) {
                case ("ADD"):
                    listEmail.add(splitCommand[1]);
                    break;
                case ("LIST"):
                    for (String item : listEmail.getSortedEmails()) {
                        System.out.println(item);
                    }
                    break;
            }
            
        }
    }
}
