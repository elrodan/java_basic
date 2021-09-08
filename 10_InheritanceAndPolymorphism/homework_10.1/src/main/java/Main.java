package main.java;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BankAccount first = new BankAccount();
        BankAccount second = new BankAccount();
        first.put(1000);
        System.out.println(first.getAmount());
        first.take(100);
        System.out.println(first.getAmount());
        first.send(second, 100);
        System.out.println(first.getAmount());
        System.out.println(second.getAmount());
    }
}
