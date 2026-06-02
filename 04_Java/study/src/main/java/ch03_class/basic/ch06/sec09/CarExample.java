package main.java.ch03_class.basic.ch06.sec09;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car("자가용");

        myCar.setSpeed(120);
        System.out.println("현재 설정 속도 : " + myCar.getSpeed());

        myCar.run();
    }
}
