package org.practice.sec03;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.practice.app.Database;

public class FindTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");

        FindIterable<Document> result = collection.find();

        for (Document doc : result) {
            System.out.println(doc);
        }
    }
}
