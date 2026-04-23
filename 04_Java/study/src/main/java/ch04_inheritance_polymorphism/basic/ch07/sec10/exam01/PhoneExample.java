package main.java.ch04_inheritance_polymorphism.basic.ch07.sec10.exam01;

public class PhoneExample {
    public static void main(String[] args) {
        //'Phone'은(는) abstract이며, 인스턴스화할 수 없습니다
        // Phone phone = new Phone();

        SmartPhone smartPhone = new SmartPhone("홍길동");
        smartPhone.turnOn();
        smartPhone.internetSearch();
        smartPhone.turnOff();
    }
}
