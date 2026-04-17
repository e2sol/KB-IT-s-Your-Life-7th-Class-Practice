package main.java.ch03_class.basic.ch06.sec08.exam03;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.setGas(5);
        myCar.isLeftGas();
        myCar.run();
        myCar.isLeftGas();
    }
}
