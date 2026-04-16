package main.java.ch01_variable_type_operator.advanced.ch02.sec13;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 스캐너 등록

        System.out.print("x 값 입력 : ");
        String strX = scanner.nextLine(); // 사용자가 입력한 값을 strX 변수에 문자열로 저장
        int x = Integer.parseInt(strX); // 문자열 strX를 정수 x값으로 저장

        System.out.print("y 값 입력 : ");
        String strY = scanner.nextLine(); // 사용자가 입력한 값을 strX 변수에 문자열로 저장
        int y = Integer.parseInt(strY); // 문자열 strX를 정수 x값으로 저장

        System.out.printf("x + y : %d", x + y);
    }
}
