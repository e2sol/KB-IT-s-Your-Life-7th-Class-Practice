package main.java.ch10_collection.advanced.ch15.sec05.exam03;

import java.util.ArrayList;
import java.util.List;

public class ComparableExample {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("홍길동", 35));
        list.add(new Person("감자바", 25));
        list.add(new Person("박지원", 31));

        list.sort(Person::compareTo);

        for (Person p : list) {
            System.out.println(p.name + ", " + p.age);
        }
    }
}
