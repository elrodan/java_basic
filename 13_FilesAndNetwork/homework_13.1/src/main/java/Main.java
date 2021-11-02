package main.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите путь до папки:");
            String path = scanner.nextLine();
            String sizeFolder = FileUtils.getSizeFile(FileUtils.calculateFolderSize(path));
            System.out.println("Размер папки " + path + " cоставляет " + sizeFolder);
        }
    }
}
