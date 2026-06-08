package org.practice.sec04;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.practice.app.Database;

import java.util.Date;

import static com.mongodb.client.model.Filters.gt;

public class UpdateManyTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("users");

        // Update 조건
        Bson query = gt("age", 16);

        // Update 내용
        Bson updates = Updates.combine(
                Updates.set("username", "modified name"),
                Updates.set("lastUpdated", new Date())
        );

        UpdateResult result = collection.updateMany(query, updates);
        System.out.println(result);
    }
}
