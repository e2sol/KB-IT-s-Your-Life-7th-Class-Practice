package main.java.ch04_inherit.basic.ch07.sec04.exam01;

public class ComputerExample {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Computer com = new Computer();

        double valueCalc = calc.areaCircle(3);
        System.out.println("Calculator 계산값: " + valueCalc);

        double valueCom = com.areaCircle(3);
        System.out.println("Computer 계산값: " + valueCom);
    }
}
