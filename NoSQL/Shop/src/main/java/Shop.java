import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Accumulators.*;
import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.unwind;

public class Shop {

    MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
    MongoDatabase database = mongoClient.getDatabase("local");
    MongoCollection<Document> shops = database.getCollection("Shops");
    MongoCollection<Document> items = database.getCollection("Items");
    String itemName;

    public void setShopName(String shopName) {
        Document shop = new Document()
                .append("Name", shopName)
                .append("Items", new ArrayList<String>());
        shops.insertOne(shop);
    }

    public void setProductName(String productName, double price) {
        Document item = new Document().append("Name", productName);
        item.append("Price", price);
        items.insertOne(item);
    }

    public void putProduct(String shopName, String itemName) {
        Document query = new Document().append("Name", shopName);
        Document update = new Document("$push", new Document("Items", itemName));
        shops.updateOne(query, update, new UpdateOptions().upsert(true));
    }

    public void getStatistics() {
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
    }

}
