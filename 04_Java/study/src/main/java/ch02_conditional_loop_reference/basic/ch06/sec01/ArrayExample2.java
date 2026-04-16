package main.java.ch02_conditional_loop_reference.basic.ch06.sec01;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample2 { // 예제 작성용 클래스
    public void ex1() {
        // 배열 선언 및 할당
        int[] arr = new int[4];

        // 1) Stack 영역에 int[] 자료형 arr 선언
        // 2) Heap 영역에 int 자료형 4개를 묶음으로 다루는 int[] 할당
        // 3) arr에 Heap 영역에 생성된 int[]의 시작 주소를 대입하여 참조하는 형태를 만듬.

        // 배열의 길이 : 배열명.length
        System.out.println("배열의 길이 : " + arr.length);

        // 배열에 값 대입하기
        // 1. 일반 for문
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 100*(i+1);
            System.out.printf("arr[%d] : %d\n", i, arr[i]);
        }

        // 2. 향상된 for문으로 값 출력하기
        System.out.println("\n향상된 for문으로 값 출력하기");
        for (int x : arr){
            System.out.println(x);

        }
    }
    public void ex2(){
        // [숙제] ----------------------------------------
        // 입력 받은 양의 정수 만큼의
        // 크기를 가지는 배열 만들기

        // [평균 점수 구하기]
        // 입력 받을 인원 수 : 4
        // 1번 점수 입력 : 100
        // 2번 점수 입력 : 20
        // 3번 점수 입력 : 50
        // 4번 점수 입력 : 90

        // 합계 : 260 점
        // 평균 : 65 점
        //-----------------------------------

        Scanner scanner = new Scanner(System.in);

        System.out.println("[평균 점수 구하기]");

        // 입력받을 인원 수 구하기
        System.out.print("입력 받을 인원 수 : ");
        int length = scanner.nextInt();

        // 점수를 저장할 배열 선언 및 합계를 받을 변수 선언
        int[] scores = new int[length];
        int sum = 0;

        // 반복문을 통해 각 배열의 요소 값을 입력받기
        for (int i = 0; i < length; i++) {
            System.out.printf("%d번 점수 입력 : ", i+1);
            scores[i] = scanner.nextInt();
            sum += scores[i];
        }

        // 합계와 평균 점수 출력
        System.out.printf("\n합계 : %d점\n", sum);
        System.out.printf("평균 : %d점\n", sum/length);
        System.out.println(Arrays.toString(scores));

    }
}
