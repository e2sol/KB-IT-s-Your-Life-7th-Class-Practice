package main.java.ch02_conditional_loop_reference.basic.ch06.sec00;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        /*
            키보드로 값을 입력하는 방법 : Scanner를 사용한다.
            (java.util.Scanner 클래스를 이용한다.)

            [사용법]
            Scanner 이름 = new Scanner(System.in);
            ex)Scanner sc = new Scanner(System.in);

            문자열 : sc.next(), sc.nextLine()
            정수 : sc.nextInt()
            실수 : sc.nextDouble(), sc.nextFloat()
	    * */

        /* next() : 다음 한 단어 (띄어쓰기 미포함)
         *           -> 띄어쓰기, Enter를 만나면 입력 종료
         * nextLine() : 다음 한 줄 (띄어쓰기 포함)
         *               -> Enter를 만나면 입력 종료
         * */

        // ** next()로 문장 작성 시 결과가 이상한 이유 **
        // 1) next() 한 단어만 읽어옴
        // 2) 입력 -> 입력 버퍼에 저장
        //     -> next() 통해 버퍼 내용을 읽어옴

        // next(), nextInt(), nextDouble() 등
        // 모두 입력 버퍼에서 (엔터)를 제외하고 내용만 읽어옴
        // -> 이 후 nextLine() 사용 시 입력받지 못하고 종료
        // -> 왜?? 입력 버퍼에 남아있는 (엔터)를 읽었기 때문에

        // --------- 실습 코드 ---------------------------

        // 스캐너 생성
        Scanner sc = new Scanner(System.in);

//        System.out.println("문자열 입력(next) : ");
//        String str1 = sc.next();
//        sc.nextLine(); // 입력 버퍼에 남아있는 값 제거
//
//        System.out.println("문자열 입력(nextLine) : ");
//        String str2 = sc.nextLine();
//
//        System.out.println("str1 : " + str1);
//        System.out.println("str2 : " + str2);

        System.out.println("-------------------------------");

        // 이름, 나이, 키 입력받기
        System.out.printf("이름 : ");
        String name = sc.nextLine();
        System.out.printf("나이 : ");
        int age = sc.nextInt();
        System.out.printf("키 : ");
        double height = sc.nextDouble();
        System.out.printf("성별(F/M) : ");
        char gender = sc.next().charAt(0);
        // 문자열.charAt(index) : index 번째 문자 하나 꺼내기

        System.out.printf("이름 : %s\n나이 : %d\n키 : %.1f\n성별 : %c", name, age, height, gender);
    }
}
