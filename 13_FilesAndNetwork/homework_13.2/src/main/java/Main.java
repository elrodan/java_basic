package main.java;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь до папки, которую хотите скопировать:");
        String srcPath = scanner.nextLine();
        System.out.println("Введите путь до папки, в которую хотите скопировать:");
        String destPath = scanner.nextLine();
        try {
            FileUtils.copyFolder(srcPath, destPath);
            System.out.println("Копирование завершено!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
