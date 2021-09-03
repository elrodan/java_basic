package main.java;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BankAccount first = new BankAccount();
        first.put(10000);
        System.out.println(first.getAmount());
        first.take(100);
        System.out.println(first.getAmount());
        CardAccount person = new CardAccount();
        person.take(100);
        System.out.println(first.getAmount());
    }
}
