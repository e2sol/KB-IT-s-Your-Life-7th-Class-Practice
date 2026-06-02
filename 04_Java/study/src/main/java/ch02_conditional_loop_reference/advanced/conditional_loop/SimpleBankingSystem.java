package main.java.ch02_conditional_loop_reference.advanced.conditional_loop;

import java.util.Scanner;

public class SimpleBankingSystem {
    public static void main(String[] args) {
        // while문과 Scanner의 nextInt() 메서드를 이용해서 키보드로부터 입력된 데이터로 예금, 출금, 조회, 종료 기능을 제공

        Scanner scanner = new Scanner(System.in);
        int select; // 번호 선택을 받을 변수
        int account = 0; // 사용자의 잔액을 저장할 변수

        while (true){
            // menu 출력
            System.out.println("\n----------------------------------");
            System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
            System.out.println("----------------------------------");

            // 사용자에게 입력값을 받음
            System.out.printf("선택 > ");
            select = scanner.nextInt();

            // 입력값에 따른 코드 작동
            if (select == 1){
                System.out.printf("예금액 > ");
                account += scanner.nextInt();
            } else if (select == 2) {
                System.out.printf("출금액 > ");
                int outMoney = scanner.nextInt();
                if (outMoney > account){
                    System.out.println("잔액이 부족합니다.");
                } else {
                    account -= outMoney;
                }
            } else if (select == 3) {
                System.out.printf("잔고 > %d\n", account);
            } else {
                break;
            }
        }
        System.out.println("\n프로그램 종료");
    }
}
