package main.java.ch03_class.basic.ch06.sec08.exam01;

public class Calculator {
    // 필드

    // 생성자
    public Calculator() {
    } // 기본 생성자

    // 메서드
    public void powerOn() {
        System.out.println("전원을 켭니다.");
    }

    public void powerOff() {
        System.out.println("전원을 끕니다.");
    }

    // 리턴값이 있는 메서드
    public int plus(int x, int y) {
        return x + y;
    }

    public double divide(int x, int y) {
        return (double) x / y;
    }
}
