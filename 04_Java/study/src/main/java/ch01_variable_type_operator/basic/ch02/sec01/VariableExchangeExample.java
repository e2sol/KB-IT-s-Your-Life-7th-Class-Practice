package main.java.ch01_variable_type_operator.basic.ch02.sec01;

public class VariableExchangeExample {
    public static void main(String[] args) {
        int x = 3;
        int y = 5;
        System.out.printf("x: %d, y: %d\n", x, y); // 변수 x, y 값을 출력

        // x와 y 값을 교환
        int data = x; // 원래의 x값을 담아둘 변수 data 선언
        x = y; y = data; // x와 y값을 교환
        System.out.printf("x: %d, y: %d", x, y); // 교환 후 x, y 값을 출력
    }
}
