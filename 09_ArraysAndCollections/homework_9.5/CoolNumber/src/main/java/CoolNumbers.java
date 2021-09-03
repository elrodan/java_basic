package main.java;

import java.util.*;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        final String[] numberLetters = new String[] {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        StringBuilder autoNumber = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for (String firstLetter : numberLetters) {
            for (int i = 0; i < 10; i++) {
                for (String secondLetter : numberLetters) {
                    for (String thirdLetter : numberLetters) {
                        for (int region = 1; region <= 199; region++) {
                            autoNumber = autoNumber.append(firstLetter).append(i).append(i).append(i).append(secondLetter).append(thirdLetter);
                            if (region < 10) {
                                autoNumber.append("0").append(region);
                            } else {
                                autoNumber.append(region);
                            }
                            list.add(autoNumber.toString());
                            autoNumber = autoNumber.delete(0, autoNumber.length());
                        }
                    }
                }
            }
        }
        return list;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        boolean outcome = false;
        long startTime = System.nanoTime();
        if (list.contains(number)) {
                outcome = true;
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Поиск перебором: номер " + (!outcome ? "не найден" : "найден") + ", поиск занял " + estimatedTime + "нс");
        return outcome;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        boolean outcome = false;
        Collections.sort(sortedList);
        long startTime = System.nanoTime();
        int index = Collections.binarySearch(sortedList, number);
        if (index >= 0) {
            outcome = true;
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Поиск бинарным поиском: номер " + (!outcome ? "не найден" : "найден") + ", поиск занял " + estimatedTime + "нс");
        return outcome;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        long startTime = System.nanoTime();
        boolean outcome = hashSet.contains(number);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Поиск поиском в HashSet: номер " + (!outcome ? "не найден" : "найден") + ", поиск занял " + estimatedTime + "нс");
        return outcome;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        long startTime = System.nanoTime();
        boolean outcome = treeSet.contains(number);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Поиск поиском в TreeSet: номер " + (!outcome ? "не найден" : "найден") + ", поиск занял " + estimatedTime + "нс");
        return outcome;
    }

}
