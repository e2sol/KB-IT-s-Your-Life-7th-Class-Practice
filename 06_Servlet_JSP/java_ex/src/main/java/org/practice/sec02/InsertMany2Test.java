package org.practice.sec02;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;
import org.practice.app.Database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsertMany2Test {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");

        List<Document> list = new ArrayList<>();

        for (int i = 10; i < 21; i++) {
            Document document = new Document();
            document.append("name", "user_"+i);
            document.append("age", i);
            document.append("created", new Date());

            list.add(document);
        }

        InsertManyResult result = collection.insertMany(list);
        System.out.println("result2 : " + result.getInsertedIds());
    }
}
