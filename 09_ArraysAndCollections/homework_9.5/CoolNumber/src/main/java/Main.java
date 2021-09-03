package main.java;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = CoolNumbers.generateCoolNumbers();
        HashSet<String> setHash = new HashSet<>(list);
        TreeSet<String> setTree = new TreeSet<>(list);
        System.out.println("Введите искомый номер");
        String input = scanner.nextLine();
        CoolNumbers.bruteForceSearchInList(list, input);
        CoolNumbers.binarySearchInList(list, input);
        CoolNumbers.searchInHashSet(setHash, input);
        CoolNumbers.searchInTreeSet(setTree, input);
    }
}
