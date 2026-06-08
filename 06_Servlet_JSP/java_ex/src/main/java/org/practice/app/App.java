package org.practice.app;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.practice.app.domain.Todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class App {
    public static void main(String[] args) {
        MongoCollection<Todo> collection = Database.getCollection("todo", Todo.class);

        // insertOne
        Todo newTodo = new Todo(null, "POJO", "POJO 테스트 확인", false);
        InsertOneResult result01 = collection.insertOne(newTodo);
        System.out.println("result01 : " + result01.getInsertedId());

        // insertMany
        List<Todo> newTodos = Arrays.asList(
                new Todo(null, "POJO2", "POJO2 테스트 확인", false),
                new Todo(null, "POJO3", "POJO3 테스트 확인", true),
                new Todo(null, "POJO4", "POJO4 테스트 확인", false)
        );
        InsertManyResult result02 = collection.insertMany(newTodos);
        System.out.println("result02 : " + result02.getInsertedIds());

        // find()
        List<Todo> todos = new ArrayList<>();
        collection.find().into(todos); // todos에 찾은 내용들을 저장

        for (Todo todo : todos) {
            System.out.println(todo);
        }

        // findOne()
        String id = "6a267312c3712d4ac0ecda3b";
        Bson query = eq("_id", new ObjectId(id));

        Todo todo = collection.find(query).first();
        System.out.println("todo : " + todo);

        Database.close();
    }
}
