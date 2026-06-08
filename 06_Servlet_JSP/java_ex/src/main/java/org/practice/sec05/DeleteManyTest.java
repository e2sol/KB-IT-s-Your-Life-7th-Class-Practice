package org.practice.sec05;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.practice.app.Database;

import static com.mongodb.client.model.Filters.gt;

public class DeleteManyTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("users");

        Bson query = gt("age", 15);

        DeleteResult result = collection.deleteMany(query);
        System.out.println("result : " + result);
    }
}
