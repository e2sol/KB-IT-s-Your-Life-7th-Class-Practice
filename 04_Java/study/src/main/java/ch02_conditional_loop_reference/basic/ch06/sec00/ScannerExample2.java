package main.java.ch02_conditional_loop_reference.basic.ch06.sec00;

import java.util.Scanner;

public class ScannerExample2 {
    public static void main(String[] args) {
        /*
		 * 1부터 사용자에게 입력 받은 수까지의 정수들의 합을
		 * for문을 이용하여 출력하세요.

			ex.
			정수를 하나 입력하세요 : 8
			1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 = 36
		 */

        // 작성한 답변
        /*
        Scanner scanner = new Scanner(System.in);

        System.out.printf("정수를 하나 입력하세요 : ");
        int num = scanner.nextInt();
        int sum = 0;

        for (int i = 1; i <= num ; i++) {
            sum += i;
            if(i<num){
                System.out.printf("%d + ", i);
            } else {
                System.out.printf("%d = ", i);
            }
        }
        System.out.printf("%d", sum);
        */

        // 풀이
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 하나 입력하세요 : ");
        int num = sc.nextInt(); // 정수 입력
        int sum = 0; // 합계 저장용 변수

        for (int i = 1; i <= num; i++) {
            if (i != num) { // 마지막 번호가 아닐 때
                System.out.print(i + " + ");
            } else { // 마지막 번호일 때
                System.out.print(i + " = ");
            }
            sum += i;
        } // for 문 종료
        System.out.print(sum);
    }
}
