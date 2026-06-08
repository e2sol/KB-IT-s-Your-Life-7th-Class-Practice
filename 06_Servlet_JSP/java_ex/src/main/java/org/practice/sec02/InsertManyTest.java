package org.practice.sec02;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;
import org.practice.app.Database;

import java.util.ArrayList;
import java.util.List;

public class InsertManyTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");

        List<Document> list = new ArrayList<>();

        Document document1 = new Document();
        document1.append("title", "Dune2 영화보기");
        document1.append("desc", "이번 주말 IMAX로 Dune2 영화보기");
        document1.append("done", false);

        list.add(document1);

        Document document2 = new Document();
        document2.append("title", "Java MongoDB 연동");
        document2.append("desc", "Java로 MongoDB 연동 프로그래밍 연습하기");
        document2.append("done", true);

        list.add(document2);

        InsertManyResult result = collection.insertMany(list);
        System.out.println("result : " + result.getInsertedIds());
    }
}
