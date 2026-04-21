package main.java.ch04_inherit.basic.ch07.sec10.exam01;

// abstract : 추상클래스 선언
public abstract class Phone {
    String owner;

    Phone(String owner) {
        this.owner = owner;
    }

    // 본문 내용이 있는 경우 추상메서드로 선언 불가
    void turnOn() {
        System.out.println("폰 전원을 켭니다");
    }

    void turnOff() {
        System.out.println("폰 전원을 끕니다.");
    }
}
