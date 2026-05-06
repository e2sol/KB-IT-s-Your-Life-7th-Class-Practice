package main.java.ch12_stream.basic.ch17.sec07.exam01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExample {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("홍길동", 30));
        studentList.add(new Student("신용권", 10));
        studentList.add(new Student("유미선", 20));

        // 점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기
        studentList.stream()
                .sorted()
                .forEach(student -> System.out.println(student.getName() + ": " + student.getScore()));
        System.out.println();

        // 점수를 기준으로 내림차순으로 정렬한 새 스트림 얻기
        studentList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(student -> System.out.println(student.getName() + ": " + student.getScore()));
    }
}
