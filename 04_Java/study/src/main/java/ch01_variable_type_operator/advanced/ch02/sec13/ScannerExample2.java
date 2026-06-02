package main.java.ch01_variable_type_operator.advanced.ch02.sec13;

import java.util.Scanner;

public class ScannerExample2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // scanner 선언
        String str = "";
        while (true){
            System.out.printf("입력 문자열 : ");
            str = scanner.nextLine();
            if (str.equals("q")){ // 문자열의 경우 비교연산자가 안 먹음
                break;
            }
            System.out.printf("출력 문자열 : %s\n", str);
        }
        System.out.printf("종료");
    }
}
