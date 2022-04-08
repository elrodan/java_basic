import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.mongodb.client.model.Accumulators.*;
import static com.mongodb.client.model.Aggregates.*;

public class Main {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase database = mongoClient.getDatabase("local");
        MongoCollection<Document> shops = database.getCollection("Shops");
        MongoCollection<Document> items = database.getCollection("Items");

        String shopName;
        String itemName;
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
                    shopName = scanner.nextLine();
                    Document shop = new Document()
                            .append("Name", shopName)
                            .append("Items", new ArrayList<String>());
                    shops.insertOne(shop);
                    break;
                case "2":
                    System.out.print("Введите название товара: ");
                    itemName = scanner.nextLine();
                    Document item = new Document().append("Name", itemName);
                    System.out.print("Введите цену товара: ");
                    String price = scanner.nextLine();
                    item.append("Price", Integer.valueOf(price));
                    items.insertOne(item);
                    break;
                case "3":
                    System.out.print("Выставить товар в магазин. \n Введите название товара: ");
                    itemName = scanner.nextLine();
                    System.out.print(" Введите название магазина: ");
                    shopName = scanner.nextLine();
                    Document query = new Document().append("Name", shopName);
                    Document update = new Document("$push", new Document("Items", itemName));
                    shops.updateOne(query, update, new UpdateOptions().upsert(true));
                    break;
                case "4":
                    System.out.println("Статистика.");
                    AggregateIterable<Document> aggregateIterable =
                            shops.aggregate(List.of(
                                    Aggregates.lookup("Items", "Items", "Name", "Statistics"),
                                    unwind("$Statistics"),
                                    group("$Name",
                                            avg("avgPrice", "$Statistics.Price"),
                                            min("minPrice", "$Statistics.Name"),
                                            max("maxPrice", "$Statistics.Name"),
                                            sum("count", 1),
                                            sum("countLessThanHundred", new Document("$cond",
                                                    Arrays.asList(new Document("$lt",
                                                            Arrays.asList("$Statistics.Price", 100)), 1, 0)))
                                           )));
                    for (Document doc : aggregateIterable) {
                        System.out.println("Магазин: " + doc.get("_id") +
                                "\n Количество товаров: " + doc.get("count") +
                                "\n Количество товаров дешевле 100 рублей: " + doc.get("countLessThanHundred") +
                                "\n Средняя стоимость товаров: " + doc.get("avgPrice") +
                                "\n Самый дешевый товар: " + doc.get("minPrice") +
                                "\n Самый дорогой товар: " + doc.get("maxPrice"));
                    }
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
