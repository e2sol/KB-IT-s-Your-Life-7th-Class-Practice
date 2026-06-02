package main.java.ch02_conditional_loop_reference.basic.ch04.sec06;

import java.util.Scanner;

public class DoWhileExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;

        System.out.printf("메세지를 입력하세요.\n");
        System.out.printf("프로그램을 종료하려면 q를 입력하세요\n");

        // do-while : 실행 결과에 따라 실행문을 반복하는 반복문
        do {
            // 실행문 작성 자리
            System.out.printf(">");
            str = scanner.nextLine();
            System.out.println(str);
        } while (!str.equals("q"));// 소괄호 내부에 실행문이 반복될 조건 작성. 조건이 true일 경우 반복

        System.out.println("프로그램 종료");
    }
}
