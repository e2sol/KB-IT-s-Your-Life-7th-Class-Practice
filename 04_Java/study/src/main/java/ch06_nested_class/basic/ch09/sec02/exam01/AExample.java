package main.java.ch06_nested_class.basic.ch09.sec02.exam01;

public class AExample {
    public static void main(String[] args) {
        // A 객체 생성
       A a = new A();

        // B 객체 생성
        A.B b = a.new B();
        // A 객체를 생성해야만 B 객체를 생성할 수 있음
    }
}
