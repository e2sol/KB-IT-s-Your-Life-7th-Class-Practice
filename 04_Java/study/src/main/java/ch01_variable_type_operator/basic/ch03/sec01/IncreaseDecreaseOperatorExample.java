package main.java.ch01_variable_type_operator.basic.ch03.sec01;

public class IncreaseDecreaseOperatorExample {
    public static void main(String[] args) {
        int x = 10;
        int y = 10;
        int z;
        x++; // x = 10으로 출력 후 x = 11로 저장
        ++x; // x = 12로 출력
        System.out.println("x=" + x);
        System.out.println("-----------------------");
        y--; // y = 10으로 출력 후 y = 9로 저장
        --y; // y = 8로 출력
        System.out.println("y=" + y);
        System.out.println("-----------------------");
        z = x++; // z에는 현재 x 값인 12로 저장 후 x=13으로 저장
        System.out.println("z=" + z); // z = 12
        System.out.println("x=" + x); // x = 13
        System.out.println("-----------------------");
        z = ++x; // x값이 14로 먼저 증가 후 z에 저장
        System.out.println("z=" + z); // z = 14
        System.out.println("x=" + x); // x = 14
        System.out.println("-----------------------");
        z = ++x + y++; // x = 15, y = 8로 계산 (z = 23) 후 y값이 9로 저장
        System.out.println("z=" + z); // z = 23
        System.out.println("x=" + x); // x = 15
        System.out.println("y=" + y); // y = 9
    }
}
