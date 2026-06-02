package main.java.ch09_collection_generic.advanced.ch15.sec02.exam01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        List<Board> list = new LinkedList<>();

        // 인스턴스 5개를 생성하여 ArrayList에 추가
        list.add(new Board("subjec01", "content01", "writer01"));
        list.add(new Board("subjec02", "content02", "writer02"));
        list.add(new Board("subjec03", "content03", "writer03"));
        list.add(new Board("subjec04", "content04", "writer04"));
        list.add(new Board("subjec05", "content05", "writer05"));

        // ArrayList에 저장된 요소의 개수 출력
        System.out.println(list.size());

        // 3번째 데이터를 추출하여 출력
        System.out.println("--------------------------------");
        System.out.println(list.get(2));

        // 일반 for문으로 순회하면서 리스트의 각 요소를 출력
        System.out.println("--------------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // 인덱스 2에 해당하는 요소 제거
        list.remove(2);
        list.remove(2);

        // 향상된 for문으로 순회하면서 리스트의 각 요소를 출력
        System.out.println("--------------------------------");
        for (Board token : list) {
            System.out.println(token);
        }
    }
}
