package org.practice.sec03;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.practice.app.Database;

import static com.mongodb.client.model.Filters.eq;

public class FindOneTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");

        String id = "6a2672595587847318a186aa"; // 준비한 id
        Bson temp = eq("_id", new ObjectId(id));

        Document result = collection.find(temp).first();
        System.out.println("result : " + result);
    }
}
