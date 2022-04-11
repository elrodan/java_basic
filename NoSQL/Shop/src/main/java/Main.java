import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Shop shop = new Shop();

        boolean exit = false;
        while (!exit) {
            System.out.println("Введите номер команды: " +
                    "Добавить магазин - 1, " +
                    "Добавить товар - 2, " +
                    "Выставить товар в магазин - 3, " +
                    "Показать статистику - 4, " +
                    "Выход - 0");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.print("Введите название магазина: ");
                    String shopName = scanner.nextLine();
                    shop.setShopName(shopName);
                    break;
                case "2":
                    System.out.print("Введите название товара: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Введите цену товара: ");
                    String price = scanner.nextLine();
                    shop.setProductName(itemName, Double.parseDouble(price));
                    break;
                case "3":
                    System.out.print("Выставить товар в магазин. \n Введите название товара: ");
                    itemName = scanner.nextLine();
                    System.out.print(" Введите название магазина: ");
                    shopName = scanner.nextLine();
                    shop.putProduct(shopName, itemName);
                    break;
                case "4":
                    System.out.println("Статистика.");
                    shop.getStatistics();
                    break;
                case "0":
                    System.out.println("Программа завершена!");
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }
}
