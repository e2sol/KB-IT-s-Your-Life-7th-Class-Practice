package main.java.ch02_conditional_loop_reference.basic.ch04.sec05;

import java.util.Scanner;

public class KeyControlExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String select;
        int speed = 0;
        while (true){
            // 메뉴 출력
            System.out.println("----------------------------");
            System.out.println("1. 증속 | 2. 감속 | 3. 중지");
            System.out.println("----------------------------");

            // 사용자가 선택 값 입력
            System.out.printf("선택 : ");
            select = scanner.nextLine();

            // 종료 선택 시 반복문 빠져나오기
            // 1, 2번 선택 시 현재 속도 증감
            if (select.equals("3")){
                break;
            } else if (select.equals("1")) {
                speed += 1;
                System.out.println("현재 속도 = "+speed);
            } else if (select.equals("2")&& speed>0) {
                speed -= 1;
                System.out.println("현재 속도 = "+speed);
            } else {
                System.out.println("다시 선택해주세요.");
            }

        }
        // 반복문 종료 이후 프로그램 종료 출력
        System.out.println("프로그램 종료");
    }
}
