package main.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        /*phoneBook.addContact("79205065654", "Маша");
        phoneBook.addContact("79205065653", "Маша");
        phoneBook.addContact("79205065654", "Маша");
        phoneBook.addContact("79205065655", "Миша");
        System.out.println(phoneBook.getAllContacts());*/
        while (true) {
            System.out.println("Введите номер, имя или команду:");
            String input = scanner.nextLine();
            if (input.equals("LIST")) {
                System.out.println(phoneBook.getAllContacts());
            } else if(input.matches("[А-Я]?[а-я]+")) {
                if (!phoneBook.getPhonesByName(input).isEmpty()) {
                    System.out.println(phoneBook.getPhonesByName(input));
                } else {
                    String name = input;
                    System.out.println("Такого имени в телефонной книге нет." +
                            System.lineSeparator() + "Введите номер телефона для абонента “"+ name +"”:");
                    input = scanner.nextLine();
                    if (phoneBook.checkContact(name, input)) {
                        phoneBook.addContact(input, name);
                        System.out.println("Контакт сохранен!");
                    } else {
                        System.out.println("Проверьте правильность введенного номера");
                        scanner.nextLine();
                    }
                }
            } else if(input.matches("^[789][\\d+]{9}$|^[78][\\d+]{10}$")) {
                if (!phoneBook.getPhonesByName(input).isEmpty()) {
                    System.out.println(phoneBook.getPhonesByName(input));
                } else {
                    String phone = input;
                    System.out.println("Такого номера нет в телефонной книге." +
                            System.lineSeparator() + "Введите имя абонента для номера “"+ phone +"”:");
                    input = scanner.nextLine();
                    if (phoneBook.checkContact(input, phone)) {
                        phoneBook.addContact(phone, input);
                        System.out.println("Контакт сохранен!");
                    } else {
                        System.out.println("Проверьте правильность введенного имени");
                        scanner.nextLine();
                    }
                }
            }
        }

    }
}
