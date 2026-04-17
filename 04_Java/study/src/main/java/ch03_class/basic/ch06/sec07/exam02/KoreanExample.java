package main.java.ch03_class.basic.ch06.sec07.exam02;

public class KoreanExample {
    public static void main(String[] args) {
        // Korean 객체 생성
        Korean korean = new Korean("박자바", "011225-1234567");

        // 또 다른 Korean 객체 생성
        Korean korean1 = new Korean("김자바", "930525-0654321");

        // 인스턴스 값을 출력
        System.out.println("korean 인스턴스 값 출력");
        System.out.println("k1.nation : " + korean.nation);
        System.out.println("k1.name : " + korean.name);
        System.out.println("k1.ssn : " + korean.ssn);

        System.out.println("\nkorean1 인스턴스 값 출력");
        System.out.println("k2.nation : " + korean1.nation);
        System.out.println("k2.name : " + korean1.name);
        System.out.println("k2.ssn : " + korean1.ssn);
    }
}
