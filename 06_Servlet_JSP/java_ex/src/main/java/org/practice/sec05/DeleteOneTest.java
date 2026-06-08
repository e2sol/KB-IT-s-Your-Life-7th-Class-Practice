package org.practice.sec05;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.practice.app.Database;

import static com.mongodb.client.model.Filters.eq;

public class DeleteOneTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("users");

        String id = "6a2676f9868554044fc768a6";
        Bson query = eq("_id", new ObjectId(id));

        DeleteResult result = collection.deleteOne(query);
        System.out.println(result);
    }
}
