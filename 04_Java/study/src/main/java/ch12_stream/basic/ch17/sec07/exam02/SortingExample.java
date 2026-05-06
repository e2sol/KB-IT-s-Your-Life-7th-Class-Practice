package main.java.ch12_stream.basic.ch17.sec07.exam02;

import main.java.ch12_stream.basic.ch17.sec07.exam01.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SortingExample {
    public static void main(String[] args) {
        List<main.java.ch12_stream.basic.ch17.sec07.exam01.Student> studentList = new ArrayList<>();
        studentList.add(new main.java.ch12_stream.basic.ch17.sec07.exam01.Student("홍길동", 30));
        studentList.add(new main.java.ch12_stream.basic.ch17.sec07.exam01.Student("신용권", 10));
        studentList.add(new main.java.ch12_stream.basic.ch17.sec07.exam01.Student("유미선", 20));

        // 점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기
        Stream<main.java.ch12_stream.basic.ch17.sec07.exam01.Student> upStream = studentList.stream().sorted(Comparator.comparingInt(main.java.ch12_stream.basic.ch17.sec07.exam01.Student::getScore));
        upStream.forEach(student -> System.out.println(student.getName() + ": " + student.getScore()));
        System.out.println();

        // 점수를 기준으로 내림차순으로 정렬한 새 스트림 얻기
        Stream<main.java.ch12_stream.basic.ch17.sec07.exam01.Student> downStream = studentList.stream().sorted(Comparator.comparingInt(Student::getScore).reversed());
        downStream.forEach(student -> System.out.println(student.getName() + ": " + student.getScore()));
    }
}
