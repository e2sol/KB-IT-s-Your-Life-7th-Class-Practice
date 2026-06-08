package org.practice.sec04;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.practice.app.Database;

import java.util.Date;

import static com.mongodb.client.model.Filters.eq;

public class UpdateOneTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("users");

        String id = "6a2676f9868554044fc768a6";
        Bson query = eq("_id", new ObjectId(id));

        // Update해서 넣을 새로운 정보
        Bson updates = Updates.combine(
                Updates.set("username", "modified name"),
                Updates.currentTimestamp("lastUpdated")
        );

        UpdateResult result = collection.updateOne(query, updates);
        System.out.println("result : " + result);
    }
}
