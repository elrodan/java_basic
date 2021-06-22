package main.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();
        int box = Integer.parseInt(boxes);
        int maxContainerInTruck = 12;
        int maxBoxesInContainer = 27;
        int truckCounter = 0;
        int containerCounter = 0;
        for (int i = 1; i <= box; i++) {
            if (i % (maxContainerInTruck * maxBoxesInContainer) == 1) {
                truckCounter++;
                System.out.println("Грузовик: " + truckCounter);
            }
            if (i % maxBoxesInContainer == 1) {
                containerCounter++;
                System.out.println("\tКонтейнер: " + containerCounter);
            }
            System.out.println("\t\tЯщик: " + i);
        }
        System.out.println("Необходимо:" + System.lineSeparator() + "грузовиков - " + truckCounter + " шт." + System.lineSeparator() + "контейнеров - " + containerCounter + " шт.");
        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }

}
